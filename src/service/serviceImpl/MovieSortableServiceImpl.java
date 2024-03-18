package service.serviceImpl;

import model.Database;
import model.Movie;
import model.Producer;
import service.MovieSortableService;
import java.util.Comparator;
public class MovieSortableServiceImpl implements MovieSortableService {

    @Override
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equals("asc")){
            Comparator<Movie> compareByName = Comparator.comparing(Movie::getName);
            Database.movies.sort(compareByName);
            System.out.println(Database.movies);
        } else if (ascOrDesc.equals("desc")) {
            Comparator<Movie> compareByName = Comparator.comparing(Movie::getName).reversed();
            Database.movies.sort(compareByName);
            System.out.println(Database.movies);
        }else{
            System.out.println();

        }
    }
    @Override
    public void sortByYear(String ascOrDesc) {
        if (ascOrDesc.equals("asc")){
            Comparator<Movie> compareByYear = Comparator.comparing(Movie::getYear);
            Database.movies.sort(compareByYear);
            System.out.println(Database.movies);
        } else if (ascOrDesc.equals("desc")) {
            Comparator<Movie> compareByYear = Comparator.comparing(Movie::getYear).reversed();
            Database.movies.sort(compareByYear);
            System.out.println(Database.movies);

        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        Comparator<Movie> compareByProducer = Comparator.comparing(
                movie -> {
                    Producer producer = movie.getProducer();
                    if (nameOrLastName.equalsIgnoreCase("firstName")) {
                        return producer.getFirstName();
                    } else {
                        return producer.getLastName();
                    }
                }
        );

        Database.movies.sort(compareByProducer);
        System.out.println(Database.movies);
    }



}
