# Nike Draw 알림서비스 + 거래 커뮤니티

# Untitled App

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

![Untitled](Nike%20Draw%20%2008dcd/Untitled.png)

### 📏 UI & Policy

---

[https://www.figma.com/embed?embed_host=notion&url=https%3A%2F%2Fwww.figma.com%2Ffile%2FaGVbw9b6x6Wh7gQqQwZep1%2FTHE-DRAW%3Fnode-id%3D0%253A1](https://www.figma.com/embed?embed_host=notion&url=https%3A%2F%2Fwww.figma.com%2Ffile%2FaGVbw9b6x6Wh7gQqQwZep1%2FTHE-DRAW%3Fnode-id%3D0%253A1)

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
