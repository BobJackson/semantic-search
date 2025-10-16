## 常见问题

### pgvector扩展问题
如果遇到"Unknown type vector"错误，请确保：
1. PostgreSQL已安装pgvector扩展
2. 数据库中执行了`CREATE EXTENSION IF NOT EXISTS vector;`
3. 验证：`SELECT * FROM pg_extension WHERE extname = 'vector';`
3. 使用的数据库是`vectordb`