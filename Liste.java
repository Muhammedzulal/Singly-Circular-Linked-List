package LinkedList3;

//!Sınavda Çıkamayacak
//&Tek Yönlü Dairesel Bağlı Liste
public class Liste {
    Node head = null;
    Node tail = null;

    void basaEkle(int data) {// ^ Başa Ekle
        Node eleman = new Node(data);
        if (head == null) { // Eğer liste boşsa, yeni eleman hem head hem tail olur
            head = eleman;
            tail = eleman;
        } else {
            eleman.next = head; // Yeni elemanın next'i mevcut head'e işaret eder
            head = eleman; // Head güncellenir ve yeni eleman head olur
        }
        // Tail'in next'i her zaman head'e işaret etmeli, dairesellik korunur
        tail.next = head;
    }

    void sonaEkle(int data) {// ^ Sona Ekle
        Node eleman = new Node(data);
        if (head == null) {
            head = eleman;
            tail = eleman;
        } else {
            tail.next = eleman; // Mevcut tail'in next'i yeni elemanı gösterir
            tail = eleman; // Tail güncellenir ve yeni eleman tail olur
        }
        tail.next = head;
    }

    void arayaEkle(int index, int data) {// ^Araya Ekle
        Node eleman = new Node(data); // Yeni eleman oluşturuluyor
        if (head == null) { // Eğer liste boşsa, yeni eleman hem head hem tail olur
            head = eleman;
            tail = eleman;
            tail.next = head;
        } else if (index == 0) { // Eğer eleman başa ekleniyorsa
            basaEkle(data); // Başa ekleme metodu çağırılır
        } else {
            Node temp = head; // Geçici değişken ile listenin başından itibaren gezilmeye başlanır
            int i = 0;
            // Belirtilen index'e kadar ilerlenir
            while (i < index - 1 && temp.next != head) {
                temp = temp.next;
                i++;
            }
            if (temp == tail) {// Geçiçi düğüm son düğüm ise
                sonaEkle(data); // Sona ekle
            } else {
                eleman.next = temp.next; // Yeni elemanın next'i, temp'in sonraki elemanını gösterir
                temp.next = eleman; // Temp'in next'i yeni elemanı gösterir
            }
        }
    }

    void bastanSil() {
        if (head == null) {// Eğer liste boşsa
            System.out.println("Liste boş");
        } else if (head == tail) { // Listede sadece bir eleman varsa
            head = null;
            tail = null; // Listeyi tamamen boşalt
        } else { // Birden fazla eleman varsa
            head = head.next; // İlk düğümü atla (sil)
            tail.next = head; // Dairesel yapıyı koru
        }
    }

    void sondanSil() {
        if (head == null) {
            System.out.println("Liste boş"); // Eğer liste boşsa
        } else if (head == tail) { // Listede sadece bir eleman varsa
            head = null;
            tail = null; // Listeyi tamamen boşalt
        } else { // Birden fazla eleman varsa
            Node temp = head;
            // Tail'den bir önceki düğümü bulana kadar ilerle
            while (temp.next != tail) {
                temp = temp.next;
            }
            tail = temp; // Yeni tail'i bir önceki düğüm yap
            tail.next = head; // Dairesel yapıyı koru
        }
    }

    void aradanSil(int index) {// ^Aradan sil
        if (head == null) { // Eğer liste boşsa
            System.out.println("Liste boş");
            return;
        }
        if (index == 0) { // Eğer baştan silinecekse (indeks 0 ise)
            bastanSil(); // Baştan silme metodunu çağır
            return;
        }

        Node temp = head;
        int sayac = 0;

        // İlgili indeksten önceki düğümü bul
        while (sayac < index - 1 && temp.next != head) {
            temp = temp.next;
            sayac++;
        }

        // İndeks listenin uzunluğundan büyükse
        if (temp.next == head) {
            System.out.println("Geçersiz indeks");
            return;
        }

        // Eğer sondan silinecekse (temp.next tail ise)
        if (temp.next == tail) {
            sondanSil(); // Sondan silme metodunu çağır
        }
        // Aradan silme işlemi
        else {
            temp.next = temp.next.next; // İlgili düğümü atla
        }
    }

    void yazdir() {// ^Yazdır
        if (head == null) {
            System.out.println("Liste boş");
            return;
        } else {
            System.out.print("[");
            Node temp = head;
            while (temp != tail) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.print(temp.data + "]");
        }
        System.out.println();
    }

}
