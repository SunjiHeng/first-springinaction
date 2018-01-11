package springinaction.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springinaction.mvc.basic.Spittle;
import springinaction.mvc.data.SpittleRepository;

import java.util.List;
import java.util.Map;

/**
 * @author HP
 * @create 2018-01-10-11:48
 */
@Controller
@RequestMapping({"/spittle"})
public class SpittleController {

    private SpittleRepository spittleRepository;
    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute (
//                spittleRepository.findSpittle (Long.MAX_VALUE, 20));
//        return "spittle";
//    }
//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        model.addAttribute ("spittleList",
//                spittleRepository.findSpittle (Long.MAX_VALUE, 20));
//        return "spittle";
//    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Map model) {
//        model.put ("spittleList",
//                spittleRepository.findSpittle (Long.MAX_VALUE, 20));
//        return "spittle";
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public List<Spittle> spittles() {
//        return spittleRespository.findSpittles(Long.MAX_VALUE,20);
//    }


    @RequestMapping(method = RequestMethod.GET)
    public String spittles(@RequestParam("max")long max, @RequestParam("count") int cout, Map map) {
        map.put ("spittleList", spittleRepository.findSpittle (max, cout));
        return "spittle";
    }

    @RequestMapping(value = "{spittleId}", method = RequestMethod.GET)
    public String spittles(@PathVariable(value = "spittleId") long spittleId, Model model) {
        model.addAttribute (spittleRepository.findOne (spittleId));
        return "spittle";
    }
}
