package gomoku.netgame;

import java.io.IOException;

public class NetThread extends Thread {
	NetGamePanel gamePanel;
	public NetThread(NetGamePanel gamePanel){
		this.gamePanel=gamePanel;
	}
	public void run() {
		while(!gamePanel.guiboard.isWin){
			try {
				sleep(100);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
			if (gamePanel.myplayer!=gamePanel.guiboard.activeplayer) {
				gamePanel.guiboard.removeListener();
				gamePanel.guiboard.Retractable=true;
				gamePanel.jbtRetract.setEnabled(true);
				try{
					int row, column;
			    	row = gamePanel.socket.getInputStream().read();
			    	column = gamePanel.socket.getInputStream().read();
					gamePanel.guiboard.SetIcon(new Integer[]{row,column,gamePanel.otherColor});
					gamePanel.guiboard.check(row, column);
					gamePanel.guiboard.step++;
					gamePanel.guiboard.changeplayer();
				}
				catch(IOException ex)
				{
					break;
				}
				if (gamePanel.guiboard.isWin){
					break;
				}
			}
			else {
				gamePanel.guiboard.isClicked=false;
				gamePanel.guiboard.AddListener();
				gamePanel.guiboard.Retractable=false;
				gamePanel.jbtRetract.setEnabled(false);
				while (true){
						if (gamePanel.guiboard.isClicked){
							try {
								gamePanel.socket.getOutputStream().write(gamePanel.guiboard.SendRow);
								gamePanel.socket.getOutputStream().write(gamePanel.guiboard.SendColumn);
								gamePanel.guiboard.isClicked=false;
								gamePanel.guiboard.changeplayer();
								break;
							} catch (IOException e1) {
								break;
							}	
						}			
//					if (gamePanel.ifRetract==1){
//						gamePanel.ifRetract=0;
//						gamePanel.guiboard.changeplayer();
//						break;
//					}
					try {
						sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
		}
	}
}
}

