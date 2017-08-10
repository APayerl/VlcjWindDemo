/*
This file is part of VlcjWindDemo.

VlcjWindDemo shows how to use the library VlcjWind
Copyright (C) 2017  Anders Payerl

VlcjWindDemo is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

VlcjWindDemo is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with VlcjWindDemo.  If not, see <http://www.gnu.org/licenses/>.

For contact use email anders{dot}payerl{at}gmail{dot}com
*/

package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import se.payerl.vlcjwind.VlcjWind;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	private VlcjWind vlcjwind;
	private MyVideoPanel myVideoPanel;
	
	public MyFrame(final VlcjWind player) {
		this.vlcjwind = player;
		this.setTitle("A Video Frame");
		this.setSize(400,400);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		myVideoPanel = new MyVideoPanel();
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				player.registerListener(myVideoPanel);
				super.windowOpened(e);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				player.unregisterListener(myVideoPanel);
				dispose();
			}
		});
		JMenuItem addMP = new JMenuItem("Add new surface");
		addMP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyFrame(vlcjwind);
			}
		});
		JMenuItem play = new JMenuItem("Play");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vlcjwind.getMediaPlayer().play();
			}
		});
		JMenuItem pause = new JMenuItem("Pause");		
		pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vlcjwind.getMediaPlayer().pause();
			}
		});
		JMenuItem stop = new JMenuItem("Stop");
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vlcjwind.getMediaPlayer().stop();
			}
		});
		JMenu menu = new JMenu("MediaPlayer controls");
		JMenuBar menuBar = new JMenuBar();
		menu.add(play);
		menu.add(pause);
		menu.add(stop);
		menu.add(addMP);
		menuBar.add(menu);
		this.add(menuBar, BorderLayout.NORTH);
		this.add(myVideoPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}
}