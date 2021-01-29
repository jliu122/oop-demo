package com.company.assignment1;

class Complex {
    // real part
    int x;
    // imaginary part
    int y;

    public Complex() {
        this.x = 0;
        this.y = 0;
    }

    public Complex(int xx, int yy) {
        this.x = xx;
        this.y = yy;
    }

    public Complex add(Complex another) {
        int i = this.x + another.x;
        int j = this.y + another.y;
        return new Complex(i, j);
    }

    public Complex multiply(Complex another) {
        int i = this.x * another.x - this.y * another.y;
        int j = this.x * another.y + this.y * another.x;
        return new Complex(i, j);
    }

    @Override
    public String toString() {
        return String.format(this.x + "+" + this.y + "i");
    }
}