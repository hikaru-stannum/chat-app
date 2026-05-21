package in.tech_camp.chat_app.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import in.tech_camp.chat_app.custom_user.CustomUserDetail;
import in.tech_camp.chat_app.entity.UserEntity;
import in.tech_camp.chat_app.form.RoomForm;
import in.tech_camp.chat_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@AllArgsConstructor
public class RoomController {
  private UserRepository userRepository;

  @GetMapping("/rooms/new")
  public String showRoomNew(@AuthenticationPrincipal CustomUserDetail currentUser, Model model) {
    List<UserEntity> users = userRepository.findAllExcept(currentUser.getId());
    model.addAttribute("users",users);
    model.addAttribute("roomForm", new RoomForm());
      return "rooms/new";
  }
}
