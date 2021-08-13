package example;

abstract public class FibonacciHelper
{
  private static String  _id = "IDL:example/Fibonacci:1.0";

  public static void insert (org.omg.CORBA.Any a, example.Fibonacci that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static example.Fibonacci extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (example.FibonacciHelper.id (), "Fibonacci");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static example.Fibonacci read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_FibonacciStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, example.Fibonacci value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static example.Fibonacci narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof example.Fibonacci)
      return (example.Fibonacci)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      example._FibonacciStub stub = new example._FibonacciStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static example.Fibonacci unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof example.Fibonacci)
      return (example.Fibonacci)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      example._FibonacciStub stub = new example._FibonacciStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

    static Fibonacci narrow(Object ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}