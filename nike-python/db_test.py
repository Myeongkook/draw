import re
import pymysql
from datetime import datetime

connect = pymysql.Connect(host='localhost', port=3306, password="qweqwe1", user="root", db="nike", charset="utf8")

result = [["\n\n\n\n\n\n\n\n\n에어 조던 1 하이 '85\n\n2/16 오전 10:00 응모 시작\n\n\n\n\n", '/kr/launch/t/men/fw/basketball/BQ4422-400/unbp45/air-jordan-1-hi-85'], ['\n\n\n\n\n\n\n\n\nSB 덩크 로우\n\n2/18 오전 10:00 응모 시작\n\n\n\n\n', '/kr/launch/t/adult-unisex/fw/action-outdoor/BQ6817-011/ymgx74/nike-sb-dunk-low-pro']]

strip = result[1][0].strip("\n").split("\n")
product_name = strip[0]
replace_date = strip[2].replace("응모 시작", "").replace("오전", "AM").replace("오후", "PM").replace(" ", "")
url = result[1][1]
message = result[1][0]
draw_date = datetime.strptime(replace_date, "%m/%d%p%I:%M").replace(year=datetime.now().year).strftime("%Y-%m-%d %H:%M")

query = 'INSERT INTO nike.draw(`date`, product, url, message, is_sent)VALUES("{date}", "{product_name}", "{url}", "{message}", 0)'\
    .format(date=draw_date, product_name=product_name, url=url, message=message)
cursor = connect.cursor()
cursor.execute(query)
connect.commit()
connect.close()



