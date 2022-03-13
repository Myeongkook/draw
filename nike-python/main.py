from selenium import webdriver
from bs4 import BeautifulSoup
from datetime import datetime
import pymysql


def crawling():
    options = webdriver.ChromeOptions()
    options.add_argument("--headless")
    options.add_argument("--no-sandbox")
    options.add_argument("--disable-dev-shm-usage")
    URL = "https://www.nike.com/kr/launch/?type=upcoming"
    driver = webdriver.Chrome(executable_path=r'/home/ubuntu/nike/webdriver/chromedriver', options=options)
    driver.get(URL)
    driver.implicitly_wait(10)
    soup = BeautifulSoup(driver.page_source, "html.parser")
    find_all = soup.find_all("div", {"class": "upcoming-card"})
    result = []
    for i in find_all:
        if "응모" in i.text:
            result.append([i.text, i.contents[3].attrs['href']])
    return result


def Insert_DB(result):
    for res in result:
        connect = pymysql.Connect(host='', port=,
                                  password="", user="", db="",
                                  charset="utf8")
        strip = res[0].strip("\n").split("\n")
        product_name = strip[0]
        replace_date = strip[2].replace("응모 시작", "").replace("오전", "AM").replace("오후", "PM").replace(" ", "")
        url = res[1]
        message = res[0]
        draw_date = datetime.strptime(replace_date, "%m/%d%p%I:%M").replace(year=datetime.now().year).strftime("%Y-%m-%d %H:%M")
        query = 'INSERT INTO nike.draw(`date`, product, url, message, is_sent)VALUES("{date}", "{product_name}", "{url}", "{message}", 0)'\
            .format(date=draw_date, product_name=product_name, url=url, message=message)
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
