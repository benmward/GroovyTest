import groovy.sql.Sql
import org.postgresql.*


class Product {
    int product_no = 4
    String name = "Dildos"
    def price = 5.49
}

def goats = "shit"
def fags = 33
def shit = "ppeeee\n"
print shit
for (int i = 0; i < 3 ; i++) {
    fags++
    shit = "${fags} times I will eat my own ${goats}."
    print "${shit}\n"
}

def db = [url:'jdbc:postgresql://localhost:5432/postgres', user:'postgres', password:'a', driver:'org.postgresql.Driver']
def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)


/*
 * Display All the records in table Products
 */
println "\n\nAll Products:"
def query = "select * from products"
sql.eachRow query, {prod->
    println prod.product_no + " "  + prod.name +" " + prod.price
}

Product dildo = new Product()
dildo.product_no = 4
dildo.name = "Dildo"
dildo.price = 7.49

/*
 * Insert a product into Product table
 */
query = "insert into products (product_no, name, price) values (?,?,?)"
sql.executeInsert query, [dildo.product_no, dildo.name, dildo.price];

/*
 * Display All the records in table Products
 */
println "\n\nAll Products:"
query = "select * from products"
sql.eachRow query, {prod->
    println prod.product_no + " "  + prod.name +" " + prod.price
}