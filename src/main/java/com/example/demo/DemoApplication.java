package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@SpringBootApplication
@Controller
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/feladat1a")
	@ResponseBody
	public String kiir1a() {
		return "<h1>Hello world!</h1>";
	}

	@GetMapping("/feladat1b")
	@ResponseBody
	public String kiir1b(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	class Adatok {
		String név;
		String cím;
		int kor;
		public Adatok(String név, String cím, int kor) {
			this.név = név;
			this.cím = cím;
			this.kor = kor;
		}
		public String getNév() {
			return név;
		}
		public String getCím() {
			return cím;
		}
		public int getKor() {
			return kor;
		}
	}

	@GetMapping("/feladat1c")
	@ResponseBody
	public  Adatok ClassKiirJSON() {
		Adatok adatok = new Adatok("Tóth Tibor", "Debrecen", 35);
		return adatok;
	}

	@GetMapping("/feladat2")
	public String kiir1bFajlbol() {
		return "szoveg";
	}

	@GetMapping("/feladat3")
	public String udvozlet( Model model) {
		model.addAttribute("nev", "Ferenc");
		model.addAttribute("magassag", 170);
		return "szoveg2";
	}

}
