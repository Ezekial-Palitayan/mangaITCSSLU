import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Manga {
    private String title;
    private int rank;
    private String type;
    private String volumes;
    private String published;
    private int members;
    private double score;

    // Constructor, getters, setters
    // Constructor
    public Manga(String title, int rank, String type, String volumes,
                 String published, int members, double score) {
        this.title = title;
        this.rank = rank;
        this.type = type;
        this.volumes = volumes;
        this.published = published;
        this.members = members;
        this.score = score;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getRank() {
        return rank;
    }

    public String getType() {
        return type;
    }

    public String getVolumes() {
        return volumes;
    }

    public String getPublished() {
        return published;
    }

    public int getMembers() {
        return members;
    }

    public double getScore() {
        return score;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVolumes(String volumes) {
        this.volumes = volumes;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "title='" + title + '\'' +
                ", rank=" + rank +
                ", type='" + type + '\'' +
                ", volumes='" + volumes + '\'' +
                ", published='" + published + '\'' +
                ", members=" + members +
                ", score=" + score +
                '}';
    }


    public class CSVProcessor {
        public static List<Manga> loadMangaData(String filePath) throws IOException {
            List<Manga> mangaList = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                // Skip header
                br.readLine();

                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Manga manga = new Manga(
                            values[1],                    // title
                            Integer.parseInt(values[2]),  // rank
                            values[3],                    // type
                            values[4],                    // volumes
                            values[5],                    // published
                            Integer.parseInt(values[6]),  // members
                            Double.parseDouble(values[9]) // score
                    );
                    mangaList.add(manga);
                }
            }
            return mangaList;
        }
    }
}
