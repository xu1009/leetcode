package nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class ReadFile {

	public void fileChannel(){
		try{
			RandomAccessFile accessFile = new RandomAccessFile("JavaNIO.java", "rw");
			FileChannel fileChannel = accessFile.getChannel();  // file channel

			ByteBuffer byteBuffer = ByteBuffer.allocate(3);  // buffer 48 is capacity

//			CharBuffer byteBuffer = CharBuffer.allocate(48);
			int byteRead = fileChannel.read(byteBuffer);  // buffer不一定是满的
			while (byteRead != -1){
				System.out.println(byteRead + "byte");
				byteBuffer.flip();   // change write mode to read mode  set position to 0 and limit to previous position
				while (byteBuffer.hasRemaining()){   // when read heck the limit
					System.out.println(byteBuffer.get());  // read one byte once time   position
				}
				byteBuffer.clear();  // clear for next read
				byteRead = fileChannel.read(byteBuffer);
			}
			accessFile.close();
		}catch(Exception exception){
			exception.printStackTrace();
		}
	}

	public void channelComunication(){
		try {
			RandomAccessFile fromFile = new RandomAccessFile("JavaNIO.java", "rw");
			FileChannel fromFileChannel = fromFile.getChannel();
			RandomAccessFile toFile = new RandomAccessFile("tofile.java", "rw");
			FileChannel toFileChannel = toFile.getChannel();
			int position = 0;
			long count = fromFileChannel.size();
			toFileChannel.transferFrom(fromFileChannel, position, count);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void tstSelector(){
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			Selector selector = Selector.open();
			SelectionKey key = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
			while (true){
				int readyChannel = selector.select();  // block until interested things happen
				if (readyChannel == 0) continue;
				Set<SelectionKey> keys = selector.selectedKeys();
				for (SelectionKey selectionKey : keys){

				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	public static void main(String[] args){
		ReadFile tst = new ReadFile();
		tst.channelComunication();
	}


}
