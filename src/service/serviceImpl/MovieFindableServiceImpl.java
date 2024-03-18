package service.serviceImpl;
import enums.Genre;
import model.Actor;
import model.Database;
import model.Movie;
import service.MovieFindableService;

import java.time.LocalDate;
import java.util.List;

public class MovieFindableServiceImpl implements MovieFindableService {
    @Override
    public List<Movie> getAllMovies() {
        return Database.movies;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie:Database.movies){
            if (movie.getName().equals(name)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
      for (Movie movie:getAllMovies()){
          for (Actor actor:movie.getActors()){
              if (actor.getActorFullName().contains(actorName)){
                  return movie;
              }
          }
      }
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie:getAllMovies()){
            if (movie.getYear().equals(year)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie:getAllMovies()){
            if (movie.getProducer().getFirstName().equals(producerFullName) || movie.getProducer().getLastName().equals(producerFullName)){

                    return movie;
                }

            }

        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie:getAllMovies()){
            if (movie.getGenre().equals(genre)){
                return movie;
            }
        }
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
       for (Movie movie:getAllMovies()){
           for (Actor actor:movie.getActors()){
               if (actor.getRole().equals(role)){
                   return movie;
               }
           }

       }
        return null;
    }
}
