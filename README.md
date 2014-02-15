In three terminal windows, run these commands

```bash
sbt 'run -server -admin.port=:9990 -result=result1'
sbt 'run -server -admin.port=:9991 -result=result2'
sbt 'run -admin.port=:9992'
```

This will start two servers, one of which serves back
the string "result1", one of which serves the string
"result2", and a client which makes a few requests and will show from which server request came.

You should get back one of each string back.
