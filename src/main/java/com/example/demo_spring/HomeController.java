package com.example.demo_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stores.Teachers;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Teachers> teachers = jdbcTemplate.query(
                "SELECT * FROM teachers",
                (rs, rowNum) -> {
                    Teachers teacher = new Teachers();
                    teacher.setId(rs.getLong("id"));
                    teacher.setFIO(rs.getString("FIO"));
                    teacher.setS_mark(rs.getInt("s_mark"));
                    teacher.setS_rank(rs.getString("s_rank"));
                    teacher.setRank(rs.getString("rank"));
                    // Маппинг коллекции disciplines
                    // Пример: List<Diciplines> disciplines = new ArrayList<>();
                    // Добавление к каждому teacher.setDisciplines(disciplines);
                    return teacher;
                }
        );

        System.out.println(teachers);

        model.addAttribute("Teachers", teachers);
        return "employeesPage";
    }
}