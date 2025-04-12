# 🧮 Amway Calculator API

一個使用 Spring Boot 實作的簡單計算機服務，支援加、減、乘、除運算，並提供 `undo` / `redo` 功能。整體設計採用 Command Pattern，具有良好的擴充性與可維護性。

---

Swagger 文件位於：  
[http://localhost:8100/swagger-ui.html](http://localhost:8100/swagger-ui.html)

---

## 📦 API 介面

| 方法     | 路徑                  | 說明             |
|----------|----------------------|------------------|
| GET      | `/add/{value}`        | 將值加入目前結果 |
| GET      | `/subtract/{value}`   | 從目前結果減去值 |
| GET      | `/multiply/{value}`   | 將目前結果乘上值 |
| GET      | `/divide/{value}`     | 將目前結果除以值 |
| GET      | `/undo`               | 復原上一步操作   |
| GET      | `/redo`               | 取消上次復原     |

### ✅ 範例

```http
GET /add/10        → 回傳 10
GET /multiply/2    → 回傳 20
GET /undo          → 回復為 10
GET /redo          → 回復為 20
```

---

## 🧠 設計概念

本專案核心使用 **Command Pattern** 來實作操作歷史記錄：
- 每個操作（加、減、乘、除）都是一個 `Command` 物件。
- 使用兩個 stack 分別記錄 `undo` 和 `redo` 歷史。
- 支援連續復原與取消復原。

---

## 📁 專案結構

```plaintext
org.example.amwaytest
├── controller         ← 控制層，處理 HTTP 請求
├── service            ← 業務邏輯層，執行操作與 undo/redo
├── command            ← 各種 Command 實作（加減乘除）
└── AmwayTestApplication.java
```