---
title: CarprojectServer
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
code_clipboard: true
highlight_theme: darkula
headingLevel: 2
generator: "@tarslib/widdershins v4.0.23"

---

# CarprojectServer


## POST Get Data

POST /api/get

> Body Parameters

```json
{
  "page": 1,
  "pageSize": 10
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» page|body|integer| yes |none|
|» pageSize|body|integer| yes |none|

> Response Examples

> OK

```json
{
  "code": 200,
  "message": "success",
  "data": {
    "page": 1,
    "pageSize": 5,
    "total": 13,
    "data": [
      {
        "id": 1,
        "user": "test_user",
        "data": "test_data",
        "createTime": "2024-07-09 22:24:04"
      },
      {
        "id": 2,
        "user": "data1",
        "data": "data1_detail",
        "createTime": "2024-07-09 22:30:30"
      },
      {
        "id": 3,
        "user": "cillum minim Excepteur esse",
        "data": "Duis ullamco aliquip ut",
        "createTime": "2024-07-09 22:41:37"
      },
      {
        "id": 4,
        "user": "sit culpa id ex ipsum",
        "data": "est",
        "createTime": "2024-07-09 22:41:40"
      },
      {
        "id": 5,
        "user": "mollit dolore esse",
        "data": "minim elit est",
        "createTime": "2024-07-09 22:41:42"
      }
    ]
  }
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

### Responses Data Schema

HTTP Status Code **200**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» message|string|true|none||none|
|» data|object|true|none||none|
|»» page|integer|true|none||none|
|»» pageSize|integer|true|none||none|
|»» total|integer|true|none||none|
|»» data|[object]|true|none||none|
|»»» id|integer|true|none||none|
|»»» user|string|true|none||none|
|»»» data|string|true|none||none|
|»»» createTime|string|true|none||none|

## POST Add Data

POST /api/insert

> Body Parameters

```json
{
  "user": "data1",
  "data": "data1_detail"
}
```

### Params

|Name|Location|Type|Required|Description|
|---|---|---|---|---|
|body|body|object| no |none|
|» user|body|string| yes |none|
|» data|body|string| yes |none|

> Response Examples

> OK

```json
{
  "code": 200,
  "message": "success",
  "data": 1
}
```

### Responses

|HTTP Status Code |Meaning|Description|Data schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|OK|Inline|

### Responses Data Schema

HTTP Status Code **200**

|Name|Type|Required|Restrictions|Title|description|
|---|---|---|---|---|---|
|» code|integer|true|none||none|
|» message|string|true|none||none|
|» data|integer|true|none||none|


