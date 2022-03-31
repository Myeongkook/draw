# Nike Draw 알림서비스 + 거래 커뮤니티

---

### 🎯 P**urpose**

1. **매일 nike에 접속하여 draw정보를 습득, draw 응모일이 되면 구독한 이용자에게 문자알림을 전송한다.**
2. **웹으로 접속하여 서비스를 구독, 상품을 거래할 수 있다.**

### 🗒️ History

---

| Version | Description | Date |
| --- | --- | --- |
| - | 화면 설계 - Figma | 2022 / 02 / 26 |
| 1.1 | 크롤러 개발 및 EC2 배포 | 2022 / 02 / 28 |
| 1.2 | 문자전송 서비스 개발 및 EC2 배포 | 2022 / 03 / 14 |

### 🍥 Architecture

---

![image](https://user-images.githubusercontent.com/52430916/160803228-de75af40-7b7a-43a5-b999-8d150c372b68.png)

### 📏 UI & Policy

---

[image](https://user-images.githubusercontent.com/52430916/160985178-e7fe16c6-676e-4811-a5ce-02924317065b.png)]

<a href="https://www.figma.com/file/aGVbw9b6x6Wh7gQqQwZep1/THE-DRAW?node-id=0%3A1">Figma 바로가기</a>

### 🛠️ Project Setting

- Spring Boot
- Spring JPA
- Lombok
- Mysql
- Git
- Redis

- Thymeleaf
- AWS EC2
- Intellij
- ReactJS
- VSCode
- Nginx

### 🗒️ ERD

---

작성 중입니다.

### 🧑🏻‍💻 Code

---

[https://github.com/Myeongkook/draw](https://github.com/Myeongkook/draw)

---

Commit Message Convention

  |Code|설명|
  |:---:|---|
  |Feat|새로운 기능을 추가할 경우|
  |Fix|버그를 고친 경우|
  |Design|CSS 등 사용자 UI 디자인 변경|
  |!BREAKING CHANGE| 커다란 API 변경의 경우|
  |!HOTFIX| 급하게 치명적인 버그를 고쳐야하는 경우|
  |Style| 코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우|
  |Refactor| 프로덕션 코드 리팩토링|
  |Comment| 필요한 주석 추가 및 변경|
  |Docs|문서를 수정한 경우|
  |Test|테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X)|
  |Rename|파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우|
  |Remove|파일을 삭제하는 작업만 수행한 경우|
