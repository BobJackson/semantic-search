## 使用大模型可以将语意化搜索增强
````bash
curl -X POST --data "1984" http://localhost:8080/books/enhanced-search
````

````
1984 is a dystopian novel written by George Orwell. The novel is set in the year 1984, hence the title, and is a chilling portrayal of a totalitarian society dominated by an omnipresent government known as "The Party". The protagonist, Winston Smith, works at the Ministry of Truth where he rewrites historical records to conform with the constantly shifting ideology of the ruling party. However, his quiet life takes a drastic turn when he starts to rebel against the Party by writing in a secret diary and falling in love with a fellow worker, Julia. This rebellion leads him into a dangerous world of conspiracy and betrayal, where Big Brother, the leader of the Party, watches everyone and enforces absolute obedience through fear. The novel serves as a powerful critique of totalitarianism, surveillance, and propaganda.
````

### 需要注意的是不同大模型的输出也是不同的


## 常见问题

### pgvector扩展问题
如果遇到"Unknown type vector"错误，请确保：
1. PostgreSQL已安装pgvector扩展
2. 数据库中执行了`CREATE EXTENSION IF NOT EXISTS vector;`
3. 验证：`SELECT * FROM pg_extension WHERE extname = 'vector';`
3. 使用的数据库是`vectordb`