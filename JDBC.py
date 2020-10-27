import pymysql


try:
    db = pymysql.connect("localhost", "username", "password", "project_name")
    cursor = db.cursor()
    print("Database Connected")
except Exception as db_error:
    print(db_error)


def create_table(table_name_parameter):
    table_create_query = "CREATE TABLE "+table_name_parameter+" (AccNo int, CustomerName varchar(20), AccBalance long);"
    try:
        i = cursor.execute(table_create_query)
        if i >= 0:
            print("Table Created Successfully...")
            db.commit()
        else:
            raise db.Error
    except db.Error as exceptionMessage:
        print(exceptionMessage)
        db.rollback()


def alter_table(table_name_parameter):
    def alter_function(query, function):
        try:
            i2 = cursor.execute(query=query)
            if i2 >= 0:
                print(function+" Table :- "+table_name_parameter)
                db.commit()
            else:
                raise db.Error
        except db.Error as exceptionMessage2:
            print(exceptionMessage2)
            db.rollback()

    while True:
        print("Alter Menu\n1) Add Column\n2) Modify Column\n"
              "3) Drop Column\n4) Rename Table\n5) Exit")
        alter_choice = int(input("Enter your choice : "))
        table_alter_query = "ALTER TABLE "+table_name_parameter+" "
        if alter_choice == 1:
            column_name = input("Enter Column Name : ")
            column_type = input("Enter Column Type : ")
            add_column_query = table_alter_query + "ADD COLUMN "+column_name+" "+column_type+";"
            alter_function(query=add_column_query, function="Column Added to")
        elif alter_choice == 2:
            column_name = input("Enter Column Name : ")
            column_type = input("Enter Column Type : ")
            modify_column_query = table_alter_query + "MODIFY COLUMN "+column_name+" "+column_type+";"
            alter_function(query=modify_column_query, function="Column Modified from")
        elif alter_choice == 3:
            column_name = input("Enter Column Name : ")
            drop_column_query = table_alter_query + "DROP COLUMN "+column_name+";"
            alter_function(query=drop_column_query, function="Column Dropped from")
        elif alter_choice == 4:
            new_table_name = input("Enter New Table Name : ")
            rename_table_query = table_alter_query + "RENAME TO "+new_table_name+";"
            alter_function(query=rename_table_query, function="Renamed Table to "+new_table_name+" from ")
        elif alter_choice == 5:
            break
        else:
            print("Wrong Alter Choice")


def truncate_table(table_name_parameter):
    table_truncate_query = "TRUNCATE TABLE "+table_name_parameter+";"
    try:
        i = cursor.execute(table_truncate_query)
        if i >= 0:
            print("Table Truncated Successfully...")
            db.commit()
        else:
            raise db.Error
    except db.Error as exceptionMessage:
        print(exceptionMessage)
        db.rollback()


def drop_table(table_name_parameter):
    table_drop_query = "DROP TABLE "+table_name_parameter+";"
    try:
        i = cursor.execute(table_drop_query)
        if i >= 0:
            print("Table Dropped Successfully...")
            db.commit()
        else:
            raise db.Error
    except db.Error as exceptionMessage:
        print(exceptionMessage)
        db.rollback()


def insert_query(table_name_parameter, name_parameter, age_parameter):
    insert_table_query = "INSERT INTO "+table_name_parameter+" VALUES(%s, %s, %s);"
    attributes = [name_parameter, age_parameter]
    try:
        i = cursor.execute(insert_table_query, attributes)
        if i > 0:
            print("Data Insertion Completed")
            db.commit()
        else:
            raise db.Error
    except db.Error as exceptionMessage:
        print(exceptionMessage)
        db.rollback()


def update_query(table_name_parameter, name_parameter, age_parameter):
    update_table_query = "UPDATE "+table_name_parameter+" SET Age = %s WHERE Name = %s;"
    attributes = [age_parameter, name_parameter]
    try:
        i = cursor.execute(update_table_query, attributes)
        if i > 0:
            print("Data Updating Completed")
            db.commit()
        else:
            raise db.Error
    except db.Error as exceptionMessage:
        print(exceptionMessage)
        db.rollback()


def delete_query(table_name_parameter, name_parameter):
    delete_table_query = "DELETE FROM "+table_name_parameter+" WHERE Name = %s;"
    attributes = [name_parameter]
    try:
        i = cursor.execute(delete_table_query, attributes)
        if i > 0:
            print("Data Deletion Completed")
            db.commit()
        else:
            raise db.Error
    except db.Error as exceptionMessage:
        print(exceptionMessage)
        db.rollback()


def select_query(table_name_parameter):
    select_table_query = "SELECT * FROM "+table_name_parameter+";"
    try:
        cursor.execute(select_table_query)
        print("Table ", table_name_parameter)
        while True:
            record = cursor.fetchone()
            if record is None:
                break
            print(record)
        db.commit()
    except db.Error as exceptionMessage:
        print(exceptionMessage)
        db.rollback()


print("Welcome into the working of Database")
while True:
    print("Menu \n1) DDL Commands\n2) DML Commands\n3) Exit")
    choice1 = int(input("Enter your choice : "))
    if choice1 == 1:
        while True:
            print("DDL Commands\n1) Create Table\n2) Alter Table"
                  "\n3) Truncate Table\n4) Drop Table\n5) Exit")
            choice2 = int(input("Enter your choice : "))
            if choice2 == 1:
                table_name = input("Enter table name :- ")
                create_table(table_name_parameter=table_name)
            elif choice2 == 2:
                table_name = input("Enter table name :- ")
                alter_table(table_name_parameter=table_name)
            elif choice2 == 3:
                table_name = input("Enter table name :- ")
                truncate_table(table_name_parameter=table_name)
            elif choice2 == 4:
                table_name = input("Enter table name :- ")
                drop_table(table_name_parameter=table_name)
            elif choice2 == 5:
                break
            else:
                print("Wrong Choice2")
    elif choice1 == 2:
        table_name = input("Enter table name : ")
        while True:
            print("DML Commands\n1) Insert\n2) Update"
                  "\n3) Delete \n4) Select\n5) Exit")
            choice3 = int(input("Enter your choice : "))
            if choice3 == 1:
                name = input("Enter Name : ")
                age = int(input("Enter Age : "))
                insert_query(table_name_parameter=table_name, name_parameter=name,
                             age_parameter=age)
            elif choice3 == 2:
                name = input("Enter Name : ")
                age = int(input("Enter Age : "))
                update_query(table_name_parameter=table_name, name_parameter=name,
                             age_parameter=age)
            elif choice3 == 3:
                name = input("Enter Name : ")
                delete_query(table_name_parameter=table_name, name_parameter=name)
            elif choice3 == 4:
                select_query(table_name_parameter=table_name)
            elif choice3 == 5:
                break
            else:
                print("Wrong Choice3")
    elif choice1 == 3:
        break
    else:
        print("Wrong Choice1")
