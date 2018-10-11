package P18_StreamFiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclEntryType;
import java.nio.file.attribute.AclFileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class E09_NIOFileAttributes {

	public static void main(String[] args) throws IOException {

		Path DIR = Paths.get("files");
		
		Path file = DIR.resolve("myFile-new.txt");
		if(Files.notExists(file))
			Files.createFile(file);
		System.out.println("Path: " + file.toString());
		
		
		
		System.out.println("\nBASIC ATTRIBUTES");
		BasicFileAttributeView basicView = Files.getFileAttributeView(file, BasicFileAttributeView.class);
		
		FileTime createTime = FileTime.from(LocalDateTime.now().minusDays(30).toInstant(ZoneOffset.UTC));
		FileTime lastModifiedTime = FileTime.from(LocalDateTime.now().minusDays(15).toInstant(ZoneOffset.UTC));
		FileTime lastAccessTime = FileTime.from(LocalDateTime.now().minusDays(5).toInstant(ZoneOffset.UTC));
		basicView.setTimes(lastModifiedTime, lastAccessTime, createTime);
		
		BasicFileAttributes basic = basicView.readAttributes();
		
		System.out.println("Creation Time: " + basic.creationTime());
		System.out.println("Last Access Time: " + basic.lastAccessTime());
		System.out.println("Last Modified Time: " + basic.lastModifiedTime());
		System.out.println("Is Directory: " + basic.isDirectory());
		System.out.println("Is Symbolic Link: " + basic.isSymbolicLink());
		System.out.println("Is Regular File: " + basic.isRegularFile());
		System.out.println("File Key: " + basic.fileKey());
		
		
		
		System.out.println("\nDOS ATTRIBUTES");
		DosFileAttributeView dosView = Files.getFileAttributeView(file,DosFileAttributeView.class);
		
		dosView.setHidden(true);
		dosView.setReadOnly(true);
		
		DosFileAttributes dos = dosView.readAttributes();
		
		System.out.println("Is Archive: " + dos.isArchive());
		System.out.println("Is Hidden: " + dos.isHidden());
		System.out.println("Is ReadOnly: " + dos.isReadOnly());
		System.out.println("Is System: " + dos.isSystem());
		
		
		
		System.out.println("\nOWNER ATTRIBUTE");
		FileOwnerAttributeView ownerView = Files.getFileAttributeView(file, FileOwnerAttributeView.class);
		
		UserPrincipal user = FileSystems.getDefault()
				                        .getUserPrincipalLookupService()
                                        .lookupPrincipalByName("juanc");
		
		ownerView.setOwner(user);

		System.out.println("File Owner: " + ownerView.getOwner());
		
		
		
		System.out.println("\nACL ATTRIBUTES");
		AclFileAttributeView aclView  =  Files.getFileAttributeView(file,  AclFileAttributeView.class);
		
		AclEntry entry = AclEntry.newBuilder().setType(AclEntryType.ALLOW)
				                              .setPrincipal(user)
				                              .setPermissions(AclEntryPermission.DELETE, 
				                            		          AclEntryPermission.READ_ATTRIBUTES,
				                            		          AclEntryPermission.READ_DATA,
				                            		          AclEntryPermission.WRITE_OWNER)
				                              .build();

		List<AclEntry> aclEntries = aclView.getAcl();
		aclEntries.clear();

		aclEntries.add(entry);
		
		aclView.getAcl().forEach(System.out::println);
		
		System.out.println("\nUSER ATTRIBUTE");
		UserDefinedFileAttributeView userView = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);

		try {
			String userDefinedAttribute = "user.mimetype";
			userView.write(userDefinedAttribute, Charset.defaultCharset().encode("text/html"));
		} catch(Exception ex) {
			System.err.println("Error: Write Access not Allowed for User Defined File Attributes");
			System.err.println(ex.getMessage());
		}
		
		userView.list().forEach(System.out::println);

	}

}
