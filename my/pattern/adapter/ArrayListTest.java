package my.pattern.adapter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public class ArrayListTest<E> extends AbstractList<E>
  implements List<E>, RandomAccess, Cloneable, Serializable
{
  private static final long serialVersionUID = 8683452581122892189L;
  private static final int DEFAULT_CAPACITY = 10;
  private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
  private transient Object[] elementData;
  private int size;
  private static final int MAX_ARRAY_SIZE = 2147483639;

  public ArrayListTest(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Illegal Capacity: " + paramInt);
    this.elementData = new Object[paramInt];
  }

  public ArrayListTest()
  {
    this.elementData = EMPTY_ELEMENTDATA;
  }

  public ArrayListTest(Collection<? extends E> paramCollection)
  {
    this.elementData = paramCollection.toArray();
    this.size = this.elementData.length;
    if (this.elementData.getClass() != [Ljava.lang.Object.class)
      this.elementData = Arrays.copyOf(this.elementData, this.size, [Ljava.lang.Object.class);
  }

  public void trimToSize()
  {
    this.modCount += 1;
    if (this.size < this.elementData.length)
      this.elementData = Arrays.copyOf(this.elementData, this.size);
  }

  public void ensureCapacity(int paramInt)
  {
    int i = this.elementData != EMPTY_ELEMENTDATA ? 0 : 10;
    if (paramInt > i)
      ensureExplicitCapacity(paramInt);
  }

  private void ensureCapacityInternal(int paramInt)
  {
    if (this.elementData == EMPTY_ELEMENTDATA)
      paramInt = Math.max(10, paramInt);
    ensureExplicitCapacity(paramInt);
  }

  private void ensureExplicitCapacity(int paramInt)
  {
    this.modCount += 1;
    if (paramInt - this.elementData.length > 0)
      grow(paramInt);
  }

  private void grow(int paramInt)
  {
    int i = this.elementData.length;
    int j = i + (i >> 1);
    if (j - paramInt < 0)
      j = paramInt;
    if (j - 2147483639 > 0)
      j = hugeCapacity(paramInt);
    this.elementData = Arrays.copyOf(this.elementData, j);
  }

  private static int hugeCapacity(int paramInt)
  {
    if (paramInt < 0)
      throw new OutOfMemoryError();
    return paramInt > 2147483639 ? 2147483647 : 2147483639;
  }

  public int size()
  {
    return this.size;
  }

  public boolean isEmpty()
  {
    return this.size == 0;
  }

  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }

  public int indexOf(Object paramObject)
  {
    int i;
    if (paramObject == null)
      for (i = 0; i < this.size; i++)
        if (this.elementData[i] == null)
          return i;
    else
      for (i = 0; i < this.size; i++)
        if (paramObject.equals(this.elementData[i]))
          return i;
    return -1;
  }

  public int lastIndexOf(Object paramObject)
  {
    int i;
    if (paramObject == null)
      for (i = this.size - 1; i >= 0; i--)
        if (this.elementData[i] == null)
          return i;
    else
      for (i = this.size - 1; i >= 0; i--)
        if (paramObject.equals(this.elementData[i]))
          return i;
    return -1;
  }



  public Object[] toArray()
  {
    return Arrays.copyOf(this.elementData, this.size);
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.size)
      return (Object[])Arrays.copyOf(this.elementData, this.size, paramArrayOfT.getClass());
    System.arraycopy(this.elementData, 0, paramArrayOfT, 0, this.size);
    if (paramArrayOfT.length > this.size)
      paramArrayOfT[this.size] = null;
    return paramArrayOfT;
  }

  E elementData(int paramInt)
  {
    return this.elementData[paramInt];
  }

  public E get(int paramInt)
  {
    rangeCheck(paramInt);
    return elementData(paramInt);
  }

  public E set(int paramInt, E paramE)
  {
    rangeCheck(paramInt);
    Object localObject = elementData(paramInt);
    this.elementData[paramInt] = paramE;
    return localObject;
  }

  public boolean add(E paramE)
  {
    ensureCapacityInternal(this.size + 1);
    this.elementData[(this.size++)] = paramE;
    return true;
  }

  public void add(int paramInt, E paramE)
  {
    rangeCheckForAdd(paramInt);
    ensureCapacityInternal(this.size + 1);
    System.arraycopy(this.elementData, paramInt, this.elementData, paramInt + 1, this.size - paramInt);
    this.elementData[paramInt] = paramE;
    this.size += 1;
  }

  public E remove(int paramInt)
  {
    rangeCheck(paramInt);
    this.modCount += 1;
    Object localObject = elementData(paramInt);
    int i = this.size - paramInt - 1;
    if (i > 0)
      System.arraycopy(this.elementData, paramInt + 1, this.elementData, paramInt, i);
    this.elementData[(--this.size)] = null;
    return localObject;
  }

  public boolean remove(Object paramObject)
  {
    int i;
    if (paramObject == null)
      for (i = 0; i < this.size; i++)
        if (this.elementData[i] == null)
        {
          fastRemove(i);
          return true;
        }
    else
      for (i = 0; i < this.size; i++)
        if (paramObject.equals(this.elementData[i]))
        {
          fastRemove(i);
          return true;
        }
    return false;
  }

  private void fastRemove(int paramInt)
  {
    this.modCount += 1;
    int i = this.size - paramInt - 1;
    if (i > 0)
      System.arraycopy(this.elementData, paramInt + 1, this.elementData, paramInt, i);
    this.elementData[(--this.size)] = null;
  }

  public void clear()
  {
    this.modCount += 1;
    for (int i = 0; i < this.size; i++)
      this.elementData[i] = null;
    this.size = 0;
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    ensureCapacityInternal(this.size + i);
    System.arraycopy(arrayOfObject, 0, this.elementData, this.size, i);
    this.size += i;
    return i != 0;
  }

  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    rangeCheckForAdd(paramInt);
    Object[] arrayOfObject = paramCollection.toArray();
    int i = arrayOfObject.length;
    ensureCapacityInternal(this.size + i);
    int j = this.size - paramInt;
    if (j > 0)
      System.arraycopy(this.elementData, paramInt, this.elementData, paramInt + i, j);
    System.arraycopy(arrayOfObject, 0, this.elementData, paramInt, i);
    this.size += i;
    return i != 0;
  }

  protected void removeRange(int paramInt1, int paramInt2)
  {
    this.modCount += 1;
    int i = this.size - paramInt2;
    System.arraycopy(this.elementData, paramInt2, this.elementData, paramInt1, i);
    int j = this.size - (paramInt2 - paramInt1);
    for (int k = j; k < this.size; k++)
      this.elementData[k] = null;
    this.size = j;
  }

  private void rangeCheck(int paramInt)
  {
    if (paramInt >= this.size)
      throw new IndexOutOfBoundsException(outOfBoundsMsg(paramInt));
  }

  private void rangeCheckForAdd(int paramInt)
  {
    if ((paramInt > this.size) || (paramInt < 0))
      throw new IndexOutOfBoundsException(outOfBoundsMsg(paramInt));
  }

  private String outOfBoundsMsg(int paramInt)
  {
    return "Index: " + paramInt + ", Size: " + this.size;
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    return batchRemove(paramCollection, false);
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return batchRemove(paramCollection, true);
  }

  private boolean batchRemove(Collection<?> paramCollection, boolean paramBoolean)
  {
    Object[] arrayOfObject = this.elementData;
    int i = 0;
    int j = 0;
    boolean bool = false;
    try
    {
      while (i < this.size)
      {
        if (paramCollection.contains(arrayOfObject[i]) == paramBoolean)
          arrayOfObject[(j++)] = arrayOfObject[i];
        i++;
      }
      if (i != this.size)
      {
        System.arraycopy(arrayOfObject, i, arrayOfObject, j, this.size - i);
        j += this.size - i;
      }
      if (j != this.size)
      {
        for (int k = j; k < this.size; k++)
          arrayOfObject[k] = null;
        this.modCount += this.size - j;
        this.size = j;
        bool = true;
      }
    }
    finally
    {
      if (i != this.size)
      {
        System.arraycopy(arrayOfObject, i, arrayOfObject, j, this.size - i);
        j += this.size - i;
      }
      if (j != this.size)
      {
        for (int m = j; m < this.size; m++)
          arrayOfObject[m] = null;
        this.modCount += this.size - j;
        this.size = j;
        bool = true;
      }
    }
    return bool;
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    int i = this.modCount;
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeInt(this.size);
    for (int j = 0; j < this.size; j++)
      paramObjectOutputStream.writeObject(this.elementData[j]);
    if (this.modCount != i)
      throw new ConcurrentModificationException();
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    this.elementData = EMPTY_ELEMENTDATA;
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream.readInt();
    if (this.size > 0)
    {
      ensureCapacityInternal(this.size);
      Object[] arrayOfObject = this.elementData;
      for (int i = 0; i < this.size; i++)
        arrayOfObject[i] = paramObjectInputStream.readObject();
    }
  }

  public ListIterator<E> listIterator(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > this.size))
      throw new IndexOutOfBoundsException("Index: " + paramInt);
    return new ListItr(paramInt);
  }

  public ListIterator<E> listIterator()
  {
    return new ListItr(0);
  }

  public Iterator<E> iterator()
  {
    return new Itr(null);
  }

  public List<E> subList(int paramInt1, int paramInt2)
  {
    subListRangeCheck(paramInt1, paramInt2, this.size);
    return new SubList(this, 0, paramInt1, paramInt2);
  }

  static void subListRangeCheck(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0)
      throw new IndexOutOfBoundsException("fromIndex = " + paramInt1);
    if (paramInt2 > paramInt3)
      throw new IndexOutOfBoundsException("toIndex = " + paramInt2);
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException("fromIndex(" + paramInt1 + ") > toIndex(" + paramInt2 + ")");
  }

  private class Itr
    implements Iterator<E>
  {
    int cursor;
    int lastRet = -1;
    int expectedModCount = ArrayList.this.modCount;

    private Itr()
    {
    }

    public boolean hasNext()
    {
      return this.cursor != ArrayList.this.size;
    }

    public E next()
    {
      checkForComodification();
      int i = this.cursor;
      if (i >= ArrayList.this.size)
        throw new NoSuchElementException();
      Object[] arrayOfObject = ArrayList.this.elementData;
      if (i >= arrayOfObject.length)
        throw new ConcurrentModificationException();
      this.cursor = (i + 1);
      return arrayOfObject[(this.lastRet = i)];
    }

    public void remove()
    {
      if (this.lastRet < 0)
        throw new IllegalStateException();
      checkForComodification();
      try
      {
        ArrayList.this.remove(this.lastRet);
        this.cursor = this.lastRet;
        this.lastRet = -1;
        this.expectedModCount = ArrayList.this.modCount;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new ConcurrentModificationException();
      }
    }

    final void checkForComodification()
    {
      if (ArrayList.this.modCount != this.expectedModCount)
        throw new ConcurrentModificationException();
    }
  }

  private class ListItr extends ArrayList<E>.Itr
    implements ListIterator<E>
  {
    ListItr(int arg2)
    {
      super(null);
      int i;
      this.cursor = i;
    }

    public boolean hasPrevious()
    {
      return this.cursor != 0;
    }

    public int nextIndex()
    {
      return this.cursor;
    }

    public int previousIndex()
    {
      return this.cursor - 1;
    }

    public E previous()
    {
      checkForComodification();
      int i = this.cursor - 1;
      if (i < 0)
        throw new NoSuchElementException();
      Object[] arrayOfObject = ArrayList.this.elementData;
      if (i >= arrayOfObject.length)
        throw new ConcurrentModificationException();
      this.cursor = i;
      return arrayOfObject[(this.lastRet = i)];
    }

    public void set(E paramE)
    {
      if (this.lastRet < 0)
        throw new IllegalStateException();
      checkForComodification();
      try
      {
        ArrayList.this.set(this.lastRet, paramE);
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new ConcurrentModificationException();
      }
    }

    public void add(E paramE)
    {
      checkForComodification();
      try
      {
        int i = this.cursor;
        ArrayList.this.add(i, paramE);
        this.cursor = (i + 1);
        this.lastRet = -1;
        this.expectedModCount = ArrayList.this.modCount;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new ConcurrentModificationException();
      }
    }
  }

  private class SubList extends AbstractList<E>
    implements RandomAccess
  {
    private final AbstractList<E> parent;
    private final int parentOffset;
    private final int offset;
    int size;

    SubList(int paramInt1, int paramInt2, int arg4)
    {
      this.parent = paramInt1;
      int i;
      this.parentOffset = i;
      this.offset = (paramInt2 + i);
      int j;
      this.size = (j - i);
      this.modCount = ArrayList.this.modCount;
    }

    public E set(int paramInt, E paramE)
    {
      rangeCheck(paramInt);
      checkForComodification();
      Object localObject = ArrayList.this.elementData(this.offset + paramInt);
      ArrayList.this.elementData[(this.offset + paramInt)] = paramE;
      return localObject;
    }

    public E get(int paramInt)
    {
      rangeCheck(paramInt);
      checkForComodification();
      return ArrayList.this.elementData(this.offset + paramInt);
    }

    public int size()
    {
      checkForComodification();
      return this.size;
    }

    public void add(int paramInt, E paramE)
    {
      rangeCheckForAdd(paramInt);
      checkForComodification();
      this.parent.add(this.parentOffset + paramInt, paramE);
      this.modCount = this.parent.modCount;
      this.size += 1;
    }

    public E remove(int paramInt)
    {
      rangeCheck(paramInt);
      checkForComodification();
      Object localObject = this.parent.remove(this.parentOffset + paramInt);
      this.modCount = this.parent.modCount;
      this.size -= 1;
      return localObject;
    }

    protected void removeRange(int paramInt1, int paramInt2)
    {
      checkForComodification();
      this.parent.removeRange(this.parentOffset + paramInt1, this.parentOffset + paramInt2);
      this.modCount = this.parent.modCount;
      this.size -= paramInt2 - paramInt1;
    }

    public boolean addAll(Collection<? extends E> paramCollection)
    {
      return addAll(this.size, paramCollection);
    }

    public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
    {
      rangeCheckForAdd(paramInt);
      int i = paramCollection.size();
      if (i == 0)
        return false;
      checkForComodification();
      this.parent.addAll(this.parentOffset + paramInt, paramCollection);
      this.modCount = this.parent.modCount;
      this.size += i;
      return true;
    }

    public Iterator<E> iterator()
    {
      return listIterator();
    }

    public ListIterator<E> listIterator(final int paramInt)
    {
      checkForComodification();
      rangeCheckForAdd(paramInt);
      final int i = this.offset;
      return new ListIterator()
      {
        int cursor = paramInt;
        int lastRet = -1;
        int expectedModCount = ArrayList.this.modCount;

        public boolean hasNext()
        {
          return this.cursor != ArrayList.SubList.this.size;
        }

        public E next()
        {
          checkForComodification();
          int i = this.cursor;
          if (i >= ArrayList.SubList.this.size)
            throw new NoSuchElementException();
          Object[] arrayOfObject = ArrayList.this.elementData;
          if (i + i >= arrayOfObject.length)
            throw new ConcurrentModificationException();
          this.cursor = (i + 1);
          return arrayOfObject[(i + (this.lastRet = i))];
        }

        public boolean hasPrevious()
        {
          return this.cursor != 0;
        }

        public E previous()
        {
          checkForComodification();
          int i = this.cursor - 1;
          if (i < 0)
            throw new NoSuchElementException();
          Object[] arrayOfObject = ArrayList.this.elementData;
          if (i + i >= arrayOfObject.length)
            throw new ConcurrentModificationException();
          this.cursor = i;
          return arrayOfObject[(i + (this.lastRet = i))];
        }

        public int nextIndex()
        {
          return this.cursor;
        }

        public int previousIndex()
        {
          return this.cursor - 1;
        }

        public void remove()
        {
          if (this.lastRet < 0)
            throw new IllegalStateException();
          checkForComodification();
          try
          {
            ArrayList.SubList.this.remove(this.lastRet);
            this.cursor = this.lastRet;
            this.lastRet = -1;
            this.expectedModCount = ArrayList.this.modCount;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            throw new ConcurrentModificationException();
          }
        }

        public void set(E paramAnonymousE)
        {
          if (this.lastRet < 0)
            throw new IllegalStateException();
          checkForComodification();
          try
          {
            ArrayList.this.set(i + this.lastRet, paramAnonymousE);
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            throw new ConcurrentModificationException();
          }
        }

        public void add(E paramAnonymousE)
        {
          checkForComodification();
          try
          {
            int i = this.cursor;
            ArrayList.SubList.this.add(i, paramAnonymousE);
            this.cursor = (i + 1);
            this.lastRet = -1;
            this.expectedModCount = ArrayList.this.modCount;
          }
          catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
          {
            throw new ConcurrentModificationException();
          }
        }

        final void checkForComodification()
        {
          if (this.expectedModCount != ArrayList.this.modCount)
            throw new ConcurrentModificationException();
        }
      };
    }

    public List<E> subList(int paramInt1, int paramInt2)
    {
      ArrayList.subListRangeCheck(paramInt1, paramInt2, this.size);
      return new SubList(ArrayList.this, this, this.offset, paramInt1, paramInt2);
    }

    private void rangeCheck(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= this.size))
        throw new IndexOutOfBoundsException(outOfBoundsMsg(paramInt));
    }

    private void rangeCheckForAdd(int paramInt)
    {
      if ((paramInt < 0) || (paramInt > this.size))
        throw new IndexOutOfBoundsException(outOfBoundsMsg(paramInt));
    }

    private String outOfBoundsMsg(int paramInt)
    {
      return "Index: " + paramInt + ", Size: " + this.size;
    }

    private void checkForComodification()
    {
      if (ArrayList.this.modCount != this.modCount)
        throw new ConcurrentModificationException();
    }
  }
}