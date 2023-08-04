package songPlaylistApplication;

import java.util.*;

public class Main {

	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {

		Album album = new Album("Album1", "Ntosh gazi");

		album.addSong("Na bado", 6);
		album.addSong("IYO", 8.6);
		album.addSong("Sebenza", 5);
		album.addSong("Nomayini", 7);
		albums.add(album);
		
		album = new Album("Album2", "Bahati");
		
		album.addSong("Mama", 5);
		album.addSong("Kumbe kumbe", 9);
		album.addSong("Size Yangu", 10);
		album.addSong("Pete Yangu", 5.8);
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<>();
		
		albums.get(0).addToPlayList("Na Bado", playList_1);
		albums.get(0).addToPlayList("IYO", playList_1);
		albums.get(1).addToPlayList("Pete Yangu", playList_1);
		albums.get(1).addToPlayList("Mama", playList_1);
		
		play(playList_1);
		
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("This playList has no song");
		}
		else {
			System.out.println("Now playing " + listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			Scanner scanner = new Scanner(System.in);
			int action = scanner.nextInt();
			scanner.nextLine();
			
			switch(action) {
			
			case 0:
				System.out.println("PlayList complete");
				quit = true;
				break;
				
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward = true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing " + listIterator.next().toString());
				}else {
					System.out.println("No song available, reached the end of the list");
					forward = false;
				}
				break;
			case 2:
				if(forward) {
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward = false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing " + listIterator.previous().toString());
				}else {
					System.out.println("We are at the first song");
					forward = false;
				}
				break;
				
			case 3:
				if(forward) {
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
						forward = false;
					}else {
						System.out.println("We are at the start of the list");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
						forward = true;
					}else {
						System.out.println("We have reached to the end of the list");
					}
				}
				break;
				
			case 4:
                 printList(playList);
                 break;
                 
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playList.size() > 0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing " + listIterator.next().toString());
					}
					else {
						if(listIterator.hasPrevious()) {
						System.out.println("Now playing " + listIterator.previous().toString());
					}
				}
			}
			}
		}
	}

	private static void printMenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - To quit\n" +
		        "1 -  To play the next song\n" +
				"2 - To play previous song\n" +
		        "3 - To replay the current song\n" +
				"4 - List of all songs\n" +
		        "5 - Print all the available options\n" +
				"6 - Delete current song");
	
	}
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		System.out.println("============================");
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		System.out.println("============================");
	}
}
