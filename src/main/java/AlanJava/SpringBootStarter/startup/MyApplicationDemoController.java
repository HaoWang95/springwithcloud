package AlanJava.SpringBootStarter.startup;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


// something wrong with RunWith annotation
@RestController
@RequestMapping("/demo")
public class MyApplicationDemoController {

    @GetMapping("")
    public Map<String, String> demo(){
        var map = new HashMap<String, String>();
        map.put("demo","This is a demo test for application entry point");
        return map;
    }

    @GetMapping("/echo")
    public Map<String, String> echo(){
        var map = new HashMap<String, String>();
        map.put("message","hello world");
        return map;
    }

    /*
    In this case, it is necessary to use @PathVariable, not @RequestParam
     */
    @GetMapping("/echoParam/{id}")
    public String echoParam(@PathVariable("id") Integer id) {
        return "The parameter provided is " + id.toString();
    }
}
