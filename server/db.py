import sqlite3
from datetime import datetime

DB_NAME = 'data/data.db'

class Store:
    def __init__(self):
        self.exec_sql('''
            CREATE TABLE IF NOT EXISTS sensor_data (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                user TEXT NOT NULL,
                data TEXT NOT NULL,
                date TEXT NOT NULL
            )
        ''')

    def exec_sql(self, sql, params = (), fetch = False):
        conn = sqlite3.connect(DB_NAME)
        cursor = conn.cursor()
        cursor.execute(sql, params)
        res = None
        if fetch:
            res = cursor.fetchall()
        conn.commit()
        cursor.close()
        conn.close()
        if fetch:
            return res

    def insert(self, user, data, date=None):
        if date is None:
            date = datetime.now().strftime('%Y-%m-%d %H:%M:%S')

        self.exec_sql('''
            INSERT INTO sensor_data (user, data, date) VALUES (?, ?, ?)
        ''', (user, data, date))

    def get(self, page, perPage):
        offset = (page - 1) * perPage
        lines = self.exec_sql('''
            SELECT * FROM sensor_data ORDER BY date DESC LIMIT ? OFFSET ?
        ''', (perPage, offset), fetch=True)

        res = []
        for line in lines:
            res.append({
                'id': line[0],
                'user': line[1],
                'data': line[2],
                'date': line[3]
            })
        return res

if __name__ == '__main__':
    store = Store()
    store.insert('user1', 'data1')
    store.insert('user2', 'data2')
    store.insert('user3', 'data3')
    print(store.get(1, 2))
