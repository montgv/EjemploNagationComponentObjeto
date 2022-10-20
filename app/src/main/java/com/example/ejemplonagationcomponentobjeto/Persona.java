package com.example.ejemplonagationcomponentobjeto;

import android.os.Parcel;
import android.os.Parcelable;

public class Persona implements Parcelable {
    String nombre;
    String apellidos;
    Integer telefono;

    public Persona(String nombre, String apellidos, int telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona {" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    protected Persona(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        if (in.readByte() == 0) {
            telefono = null;
        } else {
            telefono = in.readInt();
        }
    }

    public static final Creator<Persona> CREATOR = new Creator<Persona>() {
        @Override
        public Persona createFromParcel(Parcel parcel) {
            return null;
        }

        @Override
        public Persona[] newArray(int i) {
            return new Persona[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(apellidos);
        if (telefono == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(telefono);
        }
    }
}
