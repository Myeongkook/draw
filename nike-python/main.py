import selenium.common.exceptions
from selenium import webdriver
from bs4 import BeautifulSoup
from datetime import datetime
import chromedriver_autoinstaller
import pymysql


def crawling():
    version = chromedriver_autoinstaller.get_chrome_version().split(".")[0]
    options = webdriver.ChromeOptions()
    options.add_argument("--headless")
    options.add_argument("--no-sandbox")
    options.add_argument("--disable-dev-shm-usage")
    URL = "https://www.nike.com/kr/launch/?type=upcoming"
    try:
        driver = webdriver.Chrome(executable_path=r'/home/ubuntu/nike/' + version + '/chromedriver', options=options)
    except:
        chromedriver_autoinstaller.install(True)
        driver = webdriver.Chrome(executable_path=r'/home/ubuntu/nike/' + version + '/chromedriver', options=options)
    driver.get(URL)
    driver.implicitly_wait(10)
    soup = BeautifulSoup(driver.page_source, "html.parser")
    find_all = soup.find_all("div", {"class": "upcoming-card"})
    result = []
    for i in find_all:
        if "응모" in i.text:
            result.append([i.text, i.contents[3].attrs['href'], i.img.get('data-src')])
    return result


def Insert_DB(result):
    for res in result:
        connect = pymysql.Connect(host='', port=3306,
                                  password="", user="", db="",
                                  charset="utf8")
        strip = res[0].strip("\n").split("\n")
        product_name = strip[0]
        replace_date = strip[2].replace("응모 시작", "").replace("오전", "AM").replace("오후", "PM").replace(" ", "")
        url = 'nike.com' + res[1]
        img_url = res[2]
        draw_date = datetime.strptime(replace_date, "%m/%d%p%I:%M").replace(year=datetime.now().year).strftime("%Y-%m-%d %H:%M")
        query = 'INSERT INTO nike.draw(`date`, product, url, is_sent, img_url)VALUES("{date}", "{product_name}", "{url}", 0, "{img_url}")'\
            .format(date=draw_date, product_name=product_name, url=url, img_url=img_url)
        cursor = connect.cursor()
        try:
            cursor.execute(query)
        except pymysql.err.IntegrityError:
            cursor.close()
        connect.commit()
        connect.close()


def main():
    Insert_DB(crawling())


if __name__ == '__main__':
    main()
