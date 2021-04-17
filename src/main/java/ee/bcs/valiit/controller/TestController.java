package ee.bcs.valiit.controller;

import ee.bcs.valiit.DTO.Book;
import ee.bcs.valiit.DTO.Employee;
import ee.bcs.valiit.solution.SolutionLesson1;
import ee.bcs.valiit.tasks.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

//mille funktsioone tahame välja kutsuda, defineerib kuidas spring töötab, märgistame ära mis tegelevad veebipäringutega
public class TestController {

    @GetMapping("tere/hello-world/{nameInUrl}") //see on URL-i rida
    public String helloWorld(@PathVariable("nameInUrl") String name, @RequestParam("action") String a) {
        return a + " " + name; // urli paned http://localhost:8080/sample/hello-world/Kelly (Kelly on muutuja mida saab läbi browseri ette anda)
        //http://localhost:8080/sample/hello-world/Kelly?action=Hey
    }

    //lesson2
    //localhost:8080/fibonacci/10
    @GetMapping("fibonacci/{nth}")
    public int fibonacci(@PathVariable("nth") int nth) {
        return Lesson2.fibonacci(nth);
    }

    //Lesson2
    //localhost:8080/fibonacci?nth=10
    @GetMapping("fibonacci")
    public int fibonacci2(@RequestParam("nth") int nth) {
        return Lesson2.fibonacci(nth);
    }

    //SolutionLesson
    //URL   http://localhost:8080/min/1/5
    @GetMapping("min/{a}/{b}")
    public int min(@PathVariable("a") int a, @PathVariable("b") int b) {

        return SolutionLesson1.min(a, b);
    }

    //http://localhost:8080/min?a=1&b=5
    @GetMapping("min")
    public int min2(@RequestParam("a") int a, @RequestParam("b") int b) {

        return SolutionLesson1.min(a, b);
    }

    //Lesson1
    //http://localhost:8080/min3?a=3&b=2&c=4
    @GetMapping("min3")
    public int min3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.min3(a, b, c);
    }

    //http://localhost:8080/isEven/6
    @GetMapping("isEven/{a}")
    public boolean isEven(@PathVariable("a") int a) {
        return Lesson1.isEven(a);
    }

    //Lesson2
    //http://localhost:8080/reverseArray/2,4,1,2
    @GetMapping("reverseArray/{array}")
    public int[] reverseArray(@PathVariable("array") int[] array) {
        return Lesson2.reverseArray(array);
    }

    //http://localhost:8080/evenNumbers?a=7
    @GetMapping("evenNumbers")
    public int[] evenNumbers(@RequestParam("a") int a) {
        return Lesson2.evenNumbers(a);
    }

    //http://localhost:8080/minElement/2,3,5,1
    @GetMapping("minElement/{array}")
    public int minElement(@PathVariable("array") int[] minArray) {
        return Lesson2.min(minArray);
    }

    // http://localhost:8080/maxElement/2,20,4,17
    // kui annan algul palju numbreid, seepärasti ei lisa kohe [], tagastan ühe numbri, seepärast panen [] lõpupoole
    @GetMapping("maxElement/{array}")
    public int maxElement(@PathVariable("array") int[] maxArray) {
        return Lesson2.max(maxArray);
    }

    //http://localhost:8080/sum/2,20,4,17
    @GetMapping("sum/{array}")
    public int sum(@PathVariable("array") int[] sumArray) {
        return Lesson2.sum(sumArray);
    }

    //Lesson2b
    //http://localhost:8080/yle3?a=2&a=8&a=4
    @GetMapping("yle3")
    public int[] yle3(@RequestParam("a") int a) {
        return Lesson2b.yl3(a);
    }

    //http://localhost:8080/reversedString?=Kelly
    @GetMapping("reversedString")
    public String reversedString(@RequestParam("a") String name) {
        return Lesson3.reverseString(name);
    }

    //http://localhost:8080/morseCode/Hello
    @GetMapping("morseCode/{morse}")
    public String morse(@PathVariable("morse") String morse, @RequestParam("string") String a) {
        return morse + " " + Lesson3.morseCode(a);
    }

    //http://localhost:8080/sampleArray/
    @GetMapping("sampleArray")
    public int[] sampleArray() {
        return Lesson2b.sampleArray();
    }

    @GetMapping("test-dto")
    public Book dtoTest() {
        Book book = new Book(); // uus objekt
        book.setAuthor("author"); //lisan andmed
        book.setTitle("pealkiri");
        book.setPublishedyear(2021);
        return book; // tagastan book tüüpi vastust
    }

    @PostMapping("test-dto")
    public Book dtoTest(@RequestBody Book book) {
        return book;
    }

    //http://localhost:8080/employee
    /*@GetMapping("employee")
    public Employee dtoTest2() {
        Employee employee = new Employee();
        employee.setName("Kelly");
        employee.setAge(27);
        employee.setAddress("Tallinn");
        return employee;
    }



    @PostMapping("employee")
    public Employee dtoTest2(@RequestBody Employee employee) {
        return employee;
    }

     */

}




