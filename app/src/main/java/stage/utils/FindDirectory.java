package stage.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDirectory {

	public static Path find() {
		List<Path> resourcePath = new ArrayList<>();
		Path path = Paths.get(System.getProperty("user.dir"));
		try(Stream<Path> subPaths = Files.walk(path)) {
			resourcePath = subPaths.filter(e -> e.toString()
					.contains("resources" + File.separator + "Retro Gaming.ttf"))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resourcePath.get(0);
	}
}
