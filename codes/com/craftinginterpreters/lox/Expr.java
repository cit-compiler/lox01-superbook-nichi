package com.craftinginterpreters.lox;

import java.util.List;
abstract class Expr {
  interface Visitor<R> {
    R visitBinaryExpr(Binary expr);
    // 他の式タイプもここに追加
  }

  static class Binary extends Expr {
    final Expr left;
    final Token operator;
    final Expr right;

    Binary(Expr left, Token operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitBinaryExpr(this);
    }
  }

  abstract <R> R accept(Visitor<R> visitor);
}