import groovy.json.JsonSlurper

def jsonSlurper = new JsonSlurper()

def config = jsonSlurper.parse(new File('config.json'))
def ip = "10.10.0.0"
config.os.each {
    //Ternary operator avoid if else
    result = (it.ip !="") ? "${it.ip}":"${ip}"
    println(result)
}

println "config = $config"
println("Welcome to groovy")

