package com.example.sql.server.proxy.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "ProductsImages")
public class ProductImage {

        @Id
        @GeneratedValue
        private UUID id;

        @Column(nullable = false)
        private String name;

        @Lob
        @Column(name = "Image", columnDefinition = "VARBINARY(MAX)")
        private byte[] image;

        // 🔹 Constructores
        public ProductImage() {}

        public ProductImage(String name, byte[] image) {
            this.name = name;
            this.image = image;
        }

        // 🔹 Getters y Setters
        public UUID getId() { return id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public byte[] getImage() { return image; }
        public void setImage(byte[] image) { this.image = image; }

        @Override
        public String toString() {
                return "ProductImage{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", image=" + Arrays.toString(image) +
                        '}';
        }
}
