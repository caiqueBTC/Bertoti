package com.lab3.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Lab3Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab3Application.class, args);
	}

}

@RestController
@CrossOrigin
@RequestMapping("/weapons")
class RestApiDemoController {
	private List<Weapon> weapons = new ArrayList<>();

	public RestApiDemoController() {
		weapons.addAll(List.of(
				new Weapon("Espada"),
				new Weapon("Escudo"),
				new Weapon("Lança"),
				new Weapon("Adaga")
		));
	}

	@GetMapping
	Iterable<Weapon> getWeapons() {
		return weapons;
	}

	// @GetMapping
	// String getWeapons() {
	// 	return "<p>TesteConsumo</p>";
	// }

	@GetMapping("/{id}")
	Optional<Weapon> getWeaponById(@PathVariable String id) {
		for (Weapon c: weapons) {
			if (c.getId().equals(id)) {
				return Optional.of(c);
			}
		}

		return Optional.empty();
	}

	@PostMapping
	Weapon postWeapon(@RequestBody Weapon weapon) {
		if (weapon.getId() == null)
		{
			weapon = new Weapon(weapon.getName());
		}
		weapons.add(weapon);
		return weapon;
	}

	@PutMapping("/{id}")
	ResponseEntity<Weapon> putWeapon(@PathVariable String id,
									 @RequestBody Weapon weapon) {
		int weaponIndex = -1;

		for (Weapon w: weapons) {
			if (w.getId().equals(id)) {
				weaponIndex = weapons.indexOf(w);
				weapons.set(weaponIndex, weapon);
			}
		}

		return (weaponIndex == -1) ?
				new ResponseEntity<>(postWeapon(weapon), HttpStatus.CREATED) :
				new ResponseEntity<>(weapon, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteWeapon(@PathVariable String id) {
		weapons.removeIf(c -> c.getId().equals(id));
	}
}

class Weapon {
	private final String id;
	private String name;

	public Weapon(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Weapon(String name) {
		this(UUID.randomUUID().toString(), name);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
