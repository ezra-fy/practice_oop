require_relative 'tax_calculator'

def TaxPayer
  attr_accessor :name, :yearly_salary, :tax_credit

  def initialize(name, yearly_salary, tax_credit)
    @name = name
    @yearly_salary = yearly_salary.to_f
    @tax_credit = tax_credit.to_f
  end

  def calculate_total_tax_due
    new TaxCalculator(@yearly_salary, @tax_credit).calculate_tax_due
  end

  def to_string
    @name + " " + self.calculate_total_tax_due
  end
end
