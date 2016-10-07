package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileMain {

	public static void main(String[] args) throws IOException {
		
		//파일 객체 생성
		File file1 = new File("sample","accoutList.txt");
		
		//File newfile = new File("sample\\subsample\\copy.lnk");
		//System.out.println("asdfasdfasdf"+newfile.getName());
		
		System.out.println("파일 구분자 : "+File.separator);
		
		File file2 = new File("sample\\Chrome.lnk");
		File file3 = new File("C:\\JAVAIOT\\workspace\\workspace_se\\20.입출력[IO]\\sample\\BufferedReader.txt");
		
		System.out.println(">>file1");
		System.out.println(file1.getAbsolutePath());
		System.out.println(file1.getName());
		System.out.println(file1.getParent());
		System.out.println(file1.getPath());
		System.out.println();
		System.out.println(">>file2");
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.getName());
		System.out.println(file2.getParent());
		System.out.println(file2.getPath());
		System.out.println();
		System.out.println(">>file3");
		System.out.println(file3.getAbsolutePath());
		System.out.println(file3.getName());
		System.out.println(file3.getParent());
		System.out.println(file3.getPath());
		System.out.println();
		
		File dir1 = new File("sample");
		System.out.println("6.디렉토리 여부 : "+dir1.isDirectory());
		
		if(dir1.isDirectory()){
			System.out.println("디렉토리 : "+dir1.getName());
		}
		else if(dir1.isFile()){
			System.out.println("파일 : "+dir1.getName());			
		}
		
		System.out.println("\n>>디렉토리 목록 출력(string[])");
		String[] stringArr = dir1.list();
		for (int i = 0; i < stringArr.length; i++) {
			System.out.println(stringArr[i]);
		}
		
		
		System.out.println("\n>>디렉토리 목록 출력(file[])");
		File[] fileArr = dir1.listFiles();
		
		for (int i = 0; i < fileArr.length; i++) {
			if(fileArr[i].isDirectory()){
				System.out.println("디렉토리 : "+fileArr[i].getName());
				File[] subFileArr = fileArr[i].listFiles();
				for (int j = 0; j < subFileArr.length; j++) {
					System.out.println("\t"+subFileArr[j].getName());
				}
			}
			else if(fileArr[i].isFile()){
				System.out.println("파일 : "+fileArr[i].getName());			
			}
		}
		
		
		System.out.println("\n>>루트 디렉토리 목록");
		File[] rootDir = File.listRoots();
		for (int i = 0; i < rootDir.length; i++) {
			System.out.println(rootDir[i].getPath());
		}
		
		System.out.println("\n>>루트 디렉토리의 하위 목록");
		for (int i = 0; i < rootDir.length; i++) {
			if(rootDir[i].isDirectory()){
				System.out.println("디렉토리 : "+rootDir[i].getName());
				File[] subArr = rootDir[i].listFiles();
				for (int j = 0; j < subArr.length; j++) {
					System.out.println("\t"+subArr[j].getName());
				}
			}
			else if(rootDir[i].isFile()){
				System.out.println("파일 : "+rootDir[i].getName());			
			}
		}
		
		
		System.out.println("\n>> directory생성");
		File newDir1 = new File("newDir1");
		File newDir2 = new File("newDir2");
		File newDir3 = new File("sample", "newDir3");
		boolean isSuccess = newDir1.mkdir();
		System.out.println("newDir1 존재 여부 : "+ newDir1.exists() );
		System.out.println("newDir1 생성 성공 여부 : "+ isSuccess);
		newDir2.mkdir();
		newDir3.mkdir();
		

		System.out.println("\n>> directory 이름 변경");
		newDir2.renameTo(new File("renameDir2"));
		
		System.out.println("\n>> directory 삭제");
		newDir3.deleteOnExit();//존재하면 삭제 아님 말고
		
		System.out.println("\n>> file 생성");
		File newFile1 = new File("newFile1");
		newFile1.createNewFile();
		
		
		
		
		
		System.out.println("==============================");
		File[] files = File.listRoots();
		FileOutputStream fos = new FileOutputStream("root.txt");
		PrintStream ps = new PrintStream(fos);
		//travelDir(ps, files, 1);
		
		
		
	}
	
	public static void travelDir(PrintStream ps, File[] files, int depth){
		
		for (int i = 0; i < files.length; i++) {
			for(int j=0; j<depth; j++){
				System.out.print("\t");
				ps.print("\t");
			}
			if(files[i].isDirectory()){
				System.out.println("디렉토리 : "+files[i].getName());
				ps.println("디렉토리 : "+files[i].getName());
				File[] subFiles = files[i].listFiles();
				travelDir(ps, subFiles, depth+1);
			}
			else if(files[i].isFile()){
				System.out.println("파일 : "+files[i].getName());
				ps.println("파일 : "+files[i].getName());
			}
			ps.flush();
		}
		
	}

}
