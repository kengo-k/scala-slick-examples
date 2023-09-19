## Execute the migration

When making changes to the database, edit the `/migrations/prisma/schema.prisma` file and execute the following command.

```
npx prisma migrate dev --name <migration_name>
```

## Generate Code

To generate Scala source from the database schema, execute the following command.

```
sbt "runMain codegen.CodeGenerator"
```
