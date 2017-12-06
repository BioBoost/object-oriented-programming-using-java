# Exercises

## Boolean Expressions

Fill in the table below with the correct outcomes of the boolean expressions.

<!-- Need to do this in html as we cannot put block elements (code) inside table in markdown. -->
<table>
  <thead>
    <tr>
      <th>A</th>
      <th>B</th>
      <th>C</th>
      <th>Expression</th>
      <th>Outcome of Expression</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>`false`</code></td>
      <td><code>`false`</code></td>
      <td><code>`false`</code></td>
      <td>`A && B`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`true`</code></td>
      <td><code>`true`</code></td>
      <td><code>`false`</code></td>
      <td>`(!A) && B`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`true`</code></td>
      <td><code>`true`</code></td>
      <td><code>`true`</code></td>
      <td>`(!A) && (!B) && C`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`false`</code></td>
      <td><code>`false`</code></td>
      <td><code>`false`</code></td>
      <td>`A || B`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`false`</code></td>
      <td><code>`true`</code></td>
      <td><code>`false`</code></td>
      <td>`!(B && C)`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`false`</code></td>
      <td><code>`true`</code></td>
      <td><code>`false`</code></td>
      <td>`C || (!C)`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`false`</code></td>
      <td><code>`false`</code></td>
      <td><code>`false`</code></td>
      <td>`!(B || C)`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`false`</code></td>
      <td><code>`false`</code></td>
      <td><code>`true`</code></td>
      <td>`!((!B) || (!C))`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`false`</code></td>
      <td><code>`true`</code></td>
      <td><code>`true`</code></td>
      <td>`A && (!A)`</td>
      <td></td>
    </tr>
    <tr>
      <td><code>`true`</code></td>
      <td><code>`true`</code></td>
      <td><code>`false`</code></td>
      <td>`((!A) || (!B) && C) && !C`</td>
      <td></td>
    </tr>
  </tbody>
</table>
