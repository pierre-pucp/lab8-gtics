package sw2.lab5.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sw2.lab5.Entity.Post;
import sw2.lab5.Repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostRepository postRepository;



    @GetMapping("/post/create")
    public String nuevopost() {
        return "/post/form";
    }

    @GetMapping("/edit")
    public String editpost(Model model, @ModelAttribute("post") Post post, @RequestParam("id") int id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            post = optionalPost.get();
            model.addAttribute("post", post);
            return "/post/form";
        } else {

            return "/post/list";
        }
    }
    @PostMapping("/guardar")
    public String guardar (@ModelAttribute("post") Post post){
        postRepository.save(post);
        return "redirect: /post/list";
    }
    

    @GetMapping("")
    public String listaPost(Model model){

        List<Post> listapost=postRepository.findAll();
        model.addAttribute("lista",listapost);
        return "post/lista";
    }
    @GetMapping("/borrar")
    public String borrarpost(@RequestParam("id") int id){
        Optional<Post> opt=postRepository.findById(id);
        if(opt.isPresent())
        {
            postRepository.deleteById(id);
        }
        return "redirect:/post";

    }


}
