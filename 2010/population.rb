require_relative 'tax_payer'

class Population
  def initialize
    @population_array = []
    @total_size = 0
  end

  def add(name, salary, tax)
     @population_array.append(TaxPayer.new(name, salary, tax))
     @total_size += 1
  end

  def to_s

  end
end
