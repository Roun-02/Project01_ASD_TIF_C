# Nama Anggota Kelompok : 

- **Roganda Tua Tampubolon - 255150201111017**
- **I Putu Nara Surya Wibawa - 255150200111027**
- **Jogi Christian Siburian - 255150200111003**

## A. SINGLY LINKED LIST

### 1. `get(int index)`

```java
public Object get(int index) {
    try {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index tidak valid! Index yang diminta: " + index + ", sedangkan jumlah data: " + size + ". Index yang valid adalah 0 sampai " + (size - 1) + ".");
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.pointer;
        }
        return currentNode.data;
    } catch (IndexOutOfBoundsException e) {
        return "Error: " + e.getMessage();
    }
}
````

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
    }
}
```

Method `indexOf` digunakan untuk mencari indeks kemunculan pertama dari data yang dicari. Penelusuran dimulai dari `head` sambil membandingkan data setiap node dengan `targetData`. Jika data ditemukan, method mengembalikan indeksnya. Jika penelusuran selesai dan data tidak ditemukan, method mengembalikan `-1`.

### 3. `printReverse()`

```java
public void printReverse() {
    Object[] save = toArray();

    for (int i = size - 1; i >= 0; i--) {
        System.out.print(save[i] + ", ");
    }

    System.out.println();
}
```

Method `printReverse` digunakan untuk mencetak seluruh data dengan urutan terbalik. Karena Singly Linked List hanya memiliki pointer ke node berikutnya, data terlebih dahulu disimpan ke dalam array menggunakan method `toArray()`. Selanjutnya, array ditelusuri dari indeks terakhir hingga indeks pertama untuk mencetak data dalam urutan terbalik.

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

Method `toArray` digunakan untuk memindahkan seluruh data dari linked list ke dalam sebuah array bertipe `Object[]`. Array dibuat sesuai dengan jumlah node yang tersimpan. Penelusuran dimulai dari `head`, lalu data setiap node dimasukkan ke array secara berurutan. Setelah seluruh data disalin, array tersebut dikembalikan tanpa mengubah struktur linked list aslinya.

## **Test Case Singly Linked List**

Pengujian dilakukan menggunakan class `testSinglyLinkedList` untuk memastikan setiap method berjalan sesuai dengan hasil yang diharapkan.

| Method           | Input                                 | Hasil yang Diharapkan                              |
| ---------------- | ------------------------------------- | -------------------------------------------------- |
| `get(2)`         | Indeks `2`                            | Menghasilkan `4`                                   |
| `get(12)`        | Indeks `12`                           | Menghasilkan pesan error karena indeks tidak valid |
| `indexOf(4)`     | Data `4`                              | Menghasilkan indeks `2`                            |
| `indexOf(10)`    | Data `10`                             | Menghasilkan `-1`                                  |
| `printReverse()` | Linked list berisi `6, 5, 4, 3, 2, 1` | Mencetak `1, 2, 3, 4, 5, 6`                        |
| `print()`        | Linked list berisi `6, 5, 4, 3, 2, 1` | Mencetak `6, 5, 4, 3, 2, 1`                        |
| `remove(3)`      | Data `3`                              | Menghasilkan `true`                                |
| `remove(8)`      | Data `8`                              | Menghasilkan `false`                               |
| `toArray()`      | Linked list setelah penghapusan       | Menghasilkan array berisi `6, 5, 4, 2, 1`          |

**Catatan:** Pemanggilan `toArray()` secara langsung menggunakan `System.out.println()` akan menampilkan representasi objek array, bukan isi elemennya.

**Hasil Screenshot:**

![Hasil Test Singly Linked List](img/Hasil%20Test%20Slingly.png)

## B. DOUBLY LINKED LIST

### 1. `get(int index)`

```java
public Object get(int index) {
    try {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node2P currentNode;

        if (index < size / 2) {
            currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.data;
    } catch (IndexOutOfBoundsException e) {
        return "Error: " + e.getMessage();
    }
}
```

Method `get` digunakan untuk mengambil data berdasarkan indeks. Indeks dimulai dari `0`, yaitu posisi `head`. Method terlebih dahulu memeriksa apakah indeks berada di luar batas ukuran linked list. Jika indeks tidak valid, method melempar `IndexOutOfBoundsException`. Jika indeks valid, penelusuran dipilih berdasarkan posisi indeks. Jika indeks berada di paruh pertama (`index < size / 2`), penelusuran dilakukan dari `head` menggunakan pointer `next`. Jika indeks berada di paruh kedua, penelusuran dilakukan dari `tail` menggunakan pointer `prev`. Cara ini memanfaatkan pointer ganda pada Doubly Linked List sehingga penelusuran dapat dilakukan dari ujung yang lebih dekat dengan indeks tujuan.

### 2. `indexOf(Object targetData)`

```java
public int indexOf(Object targetData) {
    Node2P currentNode = head;
    int index = 0;

    while (currentNode != null) {
        if (currentNode.data.equals(targetData)) {
            return index;
        }

        currentNode = currentNode.next;
        index++;
    }

    return -1;
}
```

Method `indexOf` digunakan untuk mencari indeks kemunculan pertama dari data yang dicari. Penelusuran dimulai dari `head` menggunakan pointer `next` sambil membandingkan data setiap node dengan `targetData`. Jika data ditemukan, method langsung mengembalikan indeksnya. Jika penelusuran selesai dan data tidak ditemukan, method mengembalikan `-1`.

### 3. `printReverse()`

```java
public void printReverse() {
    Node2P currentNode = tail;

    while (currentNode != null) {
        System.out.print(currentNode.data + ", ");
        currentNode = currentNode.prev;
    }

    System.out.println();
}
```

Method `printReverse` digunakan untuk mencetak seluruh data dari `tail` menuju `head`. Penelusuran dimulai dari `tail` dan bergerak mundur menggunakan pointer `prev` hingga mencapai node dengan pointer `prev` bernilai `null`. Berbeda dengan Singly Linked List, method ini tidak memerlukan array bantu karena setiap node memiliki pointer ke node sebelumnya.

### 4. `remove(Object targetData)`

```java
public boolean remove(Object targetData) {
    Node2P currentNode = head;

    while (currentNode != null && !currentNode.data.equals(targetData)) {
        currentNode = currentNode.next;
    }

    if (currentNode == null) {
        return false;
    }

    if (currentNode == head) {
        deleteFirst();
    } else if (currentNode == tail) {
        deleteLast();
    } else {
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        size--;
    }

    return true;
}
```

Method `remove` digunakan untuk mencari dan menghapus node pertama yang datanya sama dengan `targetData`. Penelusuran dimulai dari `head` sampai node yang dicari ditemukan. Jika data tidak ditemukan, method mengembalikan `false`. Jika node yang dicari adalah `head`, penghapusan dilakukan menggunakan `deleteFirst()`. Jika node tersebut adalah `tail`, penghapusan dilakukan menggunakan `deleteLast()`. Jika node berada di tengah, pointer `next` dari node sebelumnya dan pointer `prev` dari node sesudahnya diperbarui agar node yang dihapus dilewati. Setelah penghapusan berhasil, method mengembalikan `true`.

### 5. `toArray()`

```java
public Object[] toArray() {
    Object[] arrObjects = new Object[size];
    Node2P currentNode = head;

    for (int i = 0; i < size; i++) {
        arrObjects[i] = currentNode.data;
        currentNode = currentNode.next;
    }

    return arrObjects;
}
```

Method `toArray` digunakan untuk mengubah seluruh data dalam Doubly Linked List menjadi array bertipe `Object[]`. Array dibuat sesuai dengan nilai `size`, kemudian penelusuran dimulai dari `head` menggunakan pointer `next`. Data setiap node disalin ke dalam array secara berurutan hingga seluruh elemen tersalin. Setelah itu, array dikembalikan tanpa mengubah struktur linked list aslinya.

## Test Case Doubly Linked List

Pengujian dilakukan menggunakan class `testDoublyLinkedList` untuk memastikan setiap method berjalan sesuai dengan hasil yang diharapkan.

| Method           | Input                                 | Hasil yang Diharapkan                              |
| ---------------- | ------------------------------------- | -------------------------------------------------- |
| `get(2)`         | Indeks `2`                            | Menghasilkan `4`                                   |
| `get(12)`        | Indeks `12`                           | Menghasilkan pesan error karena indeks tidak valid |
| `indexOf(4)`     | Data `4`                              | Menghasilkan indeks `2`                            |
| `indexOf(10)`    | Data `10`                             | Menghasilkan `-1`                                  |
| `printReverse()` | Linked list berisi `6, 5, 4, 3, 2, 1` | Mencetak `1, 2, 3, 4, 5, 6`                        |
| `print()`        | Linked list berisi `6, 5, 4, 3, 2, 1` | Mencetak `6, 5, 4, 3, 2, 1`                        |
| `remove(3)`      | Data `3`                              | Menghasilkan `true`                                |
| `remove(8)`      | Data `8`                              | Menghasilkan `false`                               |
| `toArray()`      | Linked list setelah penghapusan       | Menghasilkan array berisi `6, 5, 4, 2, 1`          |

**Catatan:** Pemanggilan `toArray()` secara langsung menggunakan `System.out.println()` akan menampilkan representasi objek array, bukan isi elemennya. Untuk menampilkan isi array, gunakan `Arrays.toString()`.

**Hasil Screenshot:**

![Hasil Test Doubly Linked List](img/Hasil%20Test%20Doubly.png)

## Kesimpulan

Berdasarkan implementasi dan pengujian yang dilakukan, Singly Linked List dan Doubly Linked List memiliki karakteristik yang berbeda dalam pengelolaan data. Singly Linked List menggunakan pointer untuk menunjuk node berikutnya, sedangkan Doubly Linked List memiliki pointer untuk menunjuk node sebelumnya dan berikutnya. Perbedaan tersebut memengaruhi proses penelusuran data, terutama pada method `get()` dan `printReverse()`. Pengujian dilakukan untuk memastikan setiap method berjalan sesuai dengan fungsinya, termasuk menangani indeks yang tidak valid serta menghapus data yang ditemukan maupun yang tidak ditemukan.
