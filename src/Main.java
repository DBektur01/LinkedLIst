import enums.Genre;
import model.Actor;
import model.Database;
import model.Movie;
import model.Producer;
import service.serviceImpl.MovieFindableServiceImpl;
import service.serviceImpl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Bektur Duyshenbek uulu
 */
public class Main {
    public static void main(String[] bek) {

        Scanner scanner = new Scanner(System.in);
        MovieFindableServiceImpl service = new MovieFindableServiceImpl();
        MovieSortableServiceImpl sort = new MovieSortableServiceImpl();

        Producer producerIamRobot = new Producer("Лоуренс"," Марк");

        List<Actor>actorsIamRobot= List.of(
                new Actor("Уилл Смит","детектив Дэл Спунер"),
                new Actor("Бриджит Мойнахан","доктор Сьюзен Келвин"),
                new Actor("Джеймс Кромвелл","доктор Альфред Лэннинг"),
                new Actor("Чи Макбрайд","лейтенант Джон Бергин")
        );
        Movie movie1 =new Movie("I'm Robot",LocalDate.of(2004,1,1),Genre.FANTASTIC,producerIamRobot,actorsIamRobot);
        Database.movies.add(movie1);

        Producer producerAvengers= new Producer("Кевин","Файги");



        List<Actor>actorsAvengers= List.of(
                new Actor("Дауни, Роберт","Железный человек"),
                new Actor("Крис Эванс","Капитан Америка"),
                new Actor("Крис Хемсворт","Тор"),
                new Actor("Марк Руффало","Халк")
        );
        Movie movieAvengers =new Movie("Avengers Final",LocalDate.of(2019,1,1),Genre.FANTASTIC,producerAvengers,actorsAvengers);
        Database.movies.add(movieAvengers);


        boolean isTrue =true;
        while (isTrue){
        System.out.println("""
                MovieFindableService:
                
                1. Get all movies
                2. Find Movie By Part Name
                3. Find Movie By Actor Name
                4. Find Movie By Year
                5. Find Movie By Producer FullName
                6. Find Movie By Genre
                7. Find Movie By Role
                
                MovieSortableService:
                         
                8. Sort Movie By Name
                9. Sort By Year
                10.Sort By Producer
                
                0.Exit
               
                """);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> System.out.println(service.getAllMovies());
            case 2 -> {
                scanner.nextLine();
                System.out.println("Write the name of the movie");
                System.out.println(service.findMovieByFullNameOrPartName(scanner.nextLine()));
            }
            case 3 -> {
                scanner.nextLine();
                System.out.println("Write the actor's name: ");
                System.out.println(service.findMovieByActorName(scanner.nextLine()));
            }
            case 4 -> {
                scanner.nextLine();
                System.out.println("Please provide the release date for the movie: ");
                System.out.println(service.findMovieByYear(LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())));
            }
            case 5 ->{
                scanner.nextLine();
                System.out.println("Please write the producer's name: ");
                System.out.println(service.findMovieByProducer(scanner.nextLine()));
            }
            case 6 -> {
                System.out.println(service.findMovieByGenre(Genre.FANTASTIC));
            }
            case 7 -> {
                scanner.nextLine();
                System.out.println("Write about the role of an actor.");
                System.out.println(service.findMovieByRole(scanner.nextLine()));
            }
            case 8 -> {
                scanner.nextLine();
                System.out.println("asc or desc");
                sort.sortMovieByName(scanner.nextLine());
            }
            case 9 -> {
                scanner.nextLine();
                System.out.println("asc or desc ");
                sort.sortByYear(scanner.nextLine());
            }
            case 10 -> {
                scanner.nextLine();
                System.out.println("Please write the producer's name: ");
                sort.sortByProducer(scanner.nextLine());
            }
            case 0 ->isTrue=false;
            default -> {
                System.out.println("1-2-3-4-5-6-7-8-9-10-0");
            }

        }
        }
    }
}