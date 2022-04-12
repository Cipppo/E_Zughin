package stage.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This utility finds the file given in the constructor, searching from the
 * directory in which the user is at the moment of the request.
 */
public class FindDirectory {

	/**
	 * Finds the file searching for it from the current active directory
	 * 
	 * @param fileName
	 * 			the name of the file to look for complete of the format specifier
	 * @return 
	 * 			the absolute path of the file
	 */
	public static Path find(String fileName) {
		List<Path> resourcePath = new ArrayList<>();
		Path path = Paths.get(System.getProperty("user.dir"));
		
		try(Stream<Path> subPaths = Files.walk(path)) {
			resourcePath = subPaths.filter(e -> e.toString()
					.contains(fileName))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return resourcePath.get(0);
	}
}
