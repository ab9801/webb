import java.net.*;
public class inetp
{
	public static void main(String[] args) throws Exception
	{
		//try
		//{
			InetAddress i = InetAddress.getLocalHost();
			System.out.println("Host Name:"+i.getHostName());
			System.out.println("Host Address:"+i.getHostAddress());
			System.out.println("Loopback Address:"+i.getLoopbackAddress());
			System.out.println("Canonical Host Name:"+i.getCanonicalHostName());
			System.out.println("Reachable:"+i.isReachable(100));
		//}

	}
}