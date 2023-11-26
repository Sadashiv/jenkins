println"Welocme to operators"
//Supports all operators
//Unary operators + and ++
def a = 2
def b = a++ * 3
println(b)
println(a)
def c = ++a * 3
println(a++)
println(c)
//Assignment operators +=, *= -=, /= %= etc
def m = 4
m += 3 //m=4 will be added to 3 in m += 3
println(m)
//Relational operators, ==, !=,>=,<=, ===, !==
def l = 2
println(l == 2)
//Logical operators, &&, ||, !
println(m==7 && l == 2)
println(m==3 || l == 2)
println(m !=3)
//precedence, !false and true take higher precedence
//bitwise operators &,|,^,~
//bit shift operators <<,>>,>>>
//Conditional operators  assert (!true)==false
//Ternary operators
def string = 'sada'
if (string!=null&&string.length()>0){
    result = 'Found'
}
else {
    result = 'Not found'
}
println(result)

tres = (string!=null&&string.length()>0) ? "Tfound":"Tnot found"
println(tres)
truthres = string ? "Tfound":"Tnot found"
println(truthres)
elvisres = string ? "Elvis found" :"Elvis not found"
println(elvisres)

//def person = Person()
//println(person)

//Object operators, Safe navigation operator, The Safe Navigation operator is used to avoid a NullPointerException
//Direct field access operator
class User{
    public final String name
    User(String name) {this.name = name} //Constructor
    String getName() {"Name: $name" } //Getter
}
def user = new User("Sadashiv")
assert user.name == "Name: Sadashiv"
println(user)
println(user.name)
assert user.@name == 'Sadashiv'
// Method pointer operator
def str = "Example of method referance"
def fun = str.&toUpperCase //When you store address we can call that variable
def upper = fun()
println(str)
println(fun)
println(upper)
//-->Method refracne pending
//Regular expression operators
//Pattern operator, java.util.regex.Matcher
//def p = ~/foo/
//assert p instanceof Pattern
def text = "Some text to match"
def mt = text =~ /match/
println(mt)
if (!mt){
    throw new RuntimeException("Oops, text not found!")
}
def mn = text ==~ /match/
println(mn)
class Car {
    String make
    String model
}
def cars = [new Car(make: 'Porshe', model: '100'), new Car(make: 'Ferrari', model:'200')]
def makes = cars*.make //*. spread operator
println(makes)
println(cars.collect{it.make})

//List<Model> models
//models = [new Model("Sadashiv"), new Model("Badagi")]
//println(models)


def items = [4,5]
def list = [1,2,3,*items, 6] //spread list elements, *items will take elements 4,5 instead of [4,5]
println(list)

//spread method arguments
int function(int x, int y, int z){
    x*y+z
}
println(function(*[4,5,6]))

def m1 = [c:3,d:4]
def map = [a:1, b:2, *:m1]
println(map)

def range = 0..5
println(range.collect()) //incldue 0 to 6
println((0..<5).collect()) // include 0 to 4

println(2 <=> 1) //spaceship operator
println('a' <=> 'z') //spaceship operator

def so = [0,1,2,3,4]
println(so[2]) //subscript operator

def msp = ["Sadashiv", "Badagi", "Babalad"]
println("Sadashiv" in msp) //membership operator
def list1 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
def list2 = ['Groovy 1.8','Groovy 2.0','Groovy 2.3']
println (list1 == list2) //Identity operator

Integer x = 123
String s = x as String //Coercion operator
println(s)
