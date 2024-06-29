package sondev.shop_food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sondev.shop_food.model.Position;
import sondev.shop_food.repository.PositionRepository;
import sondev.shop_food.utils.View;

import java.util.List;

@Controller
@RequestMapping("/admin/positions")
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;

    @GetMapping("")
    public String index(Model model) {
        List<Position> positionList = positionRepository.findAll();
        model.addAttribute("positions", positionList);
        return View.POSITION_INDEX;
    }

//    @GetMapping("/paginate")
//    public String paginate(Model mode,
//                           @RequestParam(name = "page", defaultValue = "0") int page,
//                           @RequestParam(name = "size", defaultValue = "2") int size) {
//        List<Position> positionList = positionRepository.findPaginated(page,size);
//        int totalPosition = positionRepository.count();
//        int totalPage = (int) Math.ceil((double) totalPosition / size);
//
//        mode.addAttribute("positionList", positionList);
//        mode.addAttribute("currentPage", page);
//        mode.addAttribute("totalPage", totalPage);
//        return "/position/position_list";
//    }

    @GetMapping("/create")
    public String input_position(Model model) {
        Position p = new Position();
        p.setTitle("Untitled");
        p.setStatus(0);
        model.addAttribute("new_item", p);
        return View.POSITION_CREATE;
    }

    @PostMapping("/new_position")
    public String submit_position(@ModelAttribute("new_item") Position new_item) {
        if (new_item.getTitle().equals("")) {
            new_item.setTitle("Untitled");
        }
        positionRepository.newPosition(new_item);

        return "redirect:/admin/positions";
    }

    @GetMapping("/edit/{id}")
    public String edit_position(@PathVariable String id, Model model) {
        int positionId = Integer.parseInt(id);
        Position position = positionRepository.findById(id);
        model.addAttribute("position", position);

        return "position/edit_position";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable String id, @ModelAttribute Position position) {
        int positionId = Integer.parseInt(id);
        String result = positionRepository.update(position);


        return "redirect:/admin/positions";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model) {
        int positionId = Integer.parseInt(id);
        Position position = positionRepository.findById(id);
        model.addAttribute("position", position);
        return "position/details";
    }

    @GetMapping("/delete")
    public String detail(@RequestParam String id) {
        int positionId = Integer.parseInt(id);
        String result = positionRepository.deletePosition(positionId);

        return "redirect:/admin/positions";
    }
}
