package main.java.week_7.assignment_problem;
import java.util.Arrays;

class PlaylistDemo {

    public static class Playlist {
        private final String[] songs;
        private int count;

        public Playlist(int maxCapacity) {
            if (maxCapacity < 0) {
                this.songs = new String[0];
            } else {
                this.songs = new String[maxCapacity];
            }
            this.count = 0;
        }

        public void addSong(String title) {
            if (title == null || count >= songs.length) {
                return;
            }
            songs[count++] = title;
        }

        public String[] getSongs() {
            return Arrays.copyOf(songs, count);
        }

        public int getSongCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("p.getSongs()[0] is still \"" + p.getSongs()[0] + "\"");
        System.out.println("Playlist count: " + p.getSongCount());
        System.out.println("Actual songs: " + Arrays.toString(p.getSongs()));
    }
}