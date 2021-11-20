prim 알고리즘의 시간 복잡도 
  주 반복문이 정점의 수 n만큼 반복하고, 내부 반복문이 n번 반복 -> O(n^2)


kruskal 알고리즘의 시간 복잡도 
  O(e*log e)


[prim VS kruskal]
- 그래프 내에 적은 숫자의 간선만을 가지는 '희소 그래프(sparse graph)'의 경우 -> Kruskal 알고리즘에 적합
- 그래프에 간선이 많이 존재하는 '밀집 그래프(Dense Graph)'의 경우 -> Prim 알고리즘에 적합
