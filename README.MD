# Nama Kelompok
 - **Roganda Tua Tampubolon - 255150201111017**
 - **I Putu Nara Surya Wibawa - 255150200111027**
 - **Jogi Christian Siburian - 255150200111003**

## A. SLINGLY LINKED LIST

### 1. `get(int index)`

``` java
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node CurrentNode = head;
        for (int i = 0; i < index; i++) {
            CurrentNode = CurrentNode.pointer;
        }
        return CurrentNode.data;
    }
```

Method `get` digunakan untuk mengambil data berdasarkan indeks. Indeks dimulai dari `0`, yaitu posisi `head`. Method terlebih dahulu memeriksa apakah indeks berada di luar batas ukuran linked list. Jika indeks tidak valid, method melempar `IndexOutOfBoundsException`. Jika indeks valid, penelusuran dilakukan dari `head` sampai node pada indeks yang diminta, kemudian data dari node tersebut dikembalikan.

### 2. `indexOf(Object targetData)`

```java
    public int indexOf(Object targetData) {
        Node currentNode = head;
        int index = 0;

        while (currentNode != null && !currentNode.data.equals(targetData)) {
            currentNode = currentNode.pointer;
            index++;
        }
        if (currentNode == null) {
            return -1;
        } else {
            return index;
       
```

Method `indexOf` digunakan untuk mencari indeks kemunculan pertama dari data yang dicari. Penelusuran dimulai dari `head` sambil membandingkan data setiap node dengan `targetData`. Jika data ditemukan, method mengembalikan indeksnya. Jika penelusuran selesai dan data tidak ditemukan, method mengembalikan `-1`.

### 3. `printReverse()`

```java
    public void printReverse() {
        Object[] save = toArray();
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(save[i]);
        }
    }
```

Method `printReverse` digunakan untuk mencetak seluruh data dengan urutan terbalik, dari `tail` menuju `head`. Karena Singly Linked List hanya memiliki pointer ke node berikutnya, data terlebih dahulu disimpan ke dalam array menggunakan method `toArray()`. Selanjutnya, array ditelusuri dari indeks terakhir hingga indeks pertama untuk mencetak data dalam urutan terbalik.

### 4. `remove(Object targetData)`

```java
    public boolean remove(Object targetData) {
        if (isEmpty())
            return false;

        if (head.data.equals(targetData)) {
            deleteFirst();
            return true;
        }

        Node temp = head;
        while (temp.pointer != null) {
            if (temp.pointer.data.equals(targetData)) {
                if (temp.pointer == tail) 
                    tail = temp;
                temp.pointer = temp.pointer.pointer; 
                size--;
                return true; 
            }
            temp = temp.pointer;
        }
        return false; 
    }
```

Method `remove` digunakan untuk mencari dan menghapus node pertama yang datanya sama dengan `targetData`. Jika linked list kosong, method mengembalikan `false`. Jika data yang dicari berada pada `head`, penghapusan dilakukan menggunakan `deleteFirst()`. Jika tidak, penelusuran dilakukan untuk menemukan node sebelum node yang akan dihapus. Pointer kemudian diperbarui agar node yang dihapus dilewati. Jika node yang dihapus adalah `tail`, posisi `tail` juga diperbarui. Ukuran linked list dikurangi satu dan method mengembalikan `true`. Jika data tidak ditemukan, method mengembalikan `false`.

### 5. `toArray()`

```java
    public Object[] toArray() {
        Object[] arrObjects = new Object[size];
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            arrObjects[i] = currentNode.data;
            currentNode = currentNode.pointer;
        }
        return arrObjects;
    }
```

Method `toArray` digunakan untuk memindahkan seluruh data dari linked list ke dalam sebuah array bertipe `Object[]`. Array dibuat sesuai dengan jumlah node yang tersimpan. Penelusuran dimulai dari `head`, lalu data setiap node dimasukkan ke array secara berurutan sampai `tail`. Array tersebut kemudian dikembalikan.

## B. DOUBLY LINKED LIST
