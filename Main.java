package com.Rudrajit;

import java.util.*;

public class Main {
	
	private static ArrayList<Album> albums=new ArrayList<>();
	
	public static void main(String[] args) {
		Album album=new Album("Album1","AC/DC");
		album.addSong("TNT", 4.5);
		album.addSong("Highway", 4);
		album.addSong("Rcokstar", 4.5);
		album.addSong("Dynamite", 3.5);
		
		albums.add(album);
		
		album=new Album("Album2","Eminem");
		album.addSong("See You Again",5.5);
		album.addSong("GoodBye", 4.3);
		album.addSong("Rare", 6);
		
		albums.add(album);
		
		LinkedList<Song> playList_1=new LinkedList<>();
		
		albums.get(0).addToPlayList("TNT", playList_1);
		albums.get(0).addToPlayList("Highway", playList_1);
		albums.get(1).addToPlayList("GoodBye", playList_1);
		albums.get(1).addToPlayList("Rare", playList_1);
		
		play(playList_1);
		
	}
		
	private static void play(LinkedList<Song> playList) {
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator = playList.listIterator();
		if(playList.size()==0) {
			System.out.println("This playlist has no song");
		}else {
			System.out.println("Now playing "+ listIterator.next().toString());
			printMenu();
		}
		
		while(!quit)
		{
			int action =sc.nextInt();
			sc.nextLine();
			switch(action) {
			
			case 0: 
				System.out.println("Playlist complete");
				quit=true;
				break;
			case 1:
				if(!forward) {
					if(listIterator.hasNext()) {
						listIterator.next();
					}
					forward=true;
				}
				if(listIterator.hasNext()) {
					System.out.println("Now playing "+listIterator.next().toString());
				}else {
					System.out.println("No song available, reached end of list");
					forward=false;
				}
				break;
			case 2: 
				if(forward)
				{
					if(listIterator.hasPrevious())
					{
						listIterator.previous();
					}
					forward=false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous().toString());
				}else {
					System.out.println("We are the first song");
					forward=true;
				}
				break;
			case 3:
				if(forward)
				{
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing "+listIterator.previous().toString());
						forward=false;
					}else {
						System.out.println("We are at the start of the list");
					}
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
						forward=true;
					}else {
						System.out.println("We reached to the end of list");
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
				if(playList.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
					}else {
						if(listIterator.hasPrevious())
						System.out.println("Now playing "+listIterator.previous());
					}
				}
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("Available options\n press");
		System.out.println("0 - to quit\n" + "1 - to play next song\n" + "2 - play previous song\n" + 
		"3 - to replay the current song\n"+ 
		"4 - list of all songs \n"+
		"5 - print all available options\n"+
		"6 - delete current song");
	}
	
	private static void printList(LinkedList<Song> playList)
	{
		Iterator<Song> iterator=playList.iterator();
		System.out.println("--------------------");
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		System.out.println("---------------------");
		
	}
}

