[comment]: metadata=Java Solution to problem Sudoku Solver using Backtracking.
[comment]: keywords=Sudoku Solver, Backtracking
[comment]: robots=index, follow


<h1>Sudoku Solver</h1>
<p>
This page explains Java solution to problem <code class="inline">Sudoku Solver</code> using <code class="inline">Backtracking</code>.
</p>


<h2 class="heading">Problem Statement</h2>
<p>
Write a program to solve a <a href="https://simple.wikipedia.org/wiki/Sudoku" class="absolute" target="_blank" rel="noopener noreferrer">Sudoku puzzle</a> by filling the empty cells. Empty cells are indicated by the character <code class="inline">.</code>. 
</p>

<b>Example 1:</b>
<p>Input: A Sudoku Puzzle</p>
<img title="Sudoku Puzzle Input" alt="Sudoku Puzzle Input" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png" />

<p class="paragraph-heading">Output: It's Solution number marked in Red</p>
<img title="Sudoku Puzzle Output" alt="Sudoku Puzzle Output" src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Sudoku-by-L2G-20050714_solution.svg/250px-Sudoku-by-L2G-20050714_solution.svg.png" />


<h2 class="heading">Solution</h2>
If you have any suggestions in below code, please <a href="####LINK_PLACEHOLDER####" target="_blank" rel="noopener noreferrer" class="absolute">create a pull request by clicking here</a>.
<pre>
<code class="language-java">
####CODE_PLACEHOLDER####
</code>
</pre>


<h2 class="heading">Time Complexity</h2>
<blockquote>
<p>
O(9!)<sup>9</sup> <br />
For single Row there are 
    9 possibilities for first cell <br />
    8 possibilities for second cell <br />
    7 possibilities for third cell and so .... <br />
So total there are 9! operations to fill in one row <br />
 <br /> <br />
There are 9 Rows in Sudoku, so total number of operations will be 9!<sup>9</sup> <br />
</p>
</blockquote>


<h2 class="heading">Space Complexity</h2>
<blockquote>
<p>
O(9 * 9)
For storing 9 * 9 Grid
</p>
</blockquote>