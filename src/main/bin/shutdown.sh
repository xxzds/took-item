#!/bin/sh

#if [ -z "$1" ]; then
#        echo "请在参数中指定进程Id文件的名称！"
#        exit 1
#fi

kill -15 `cat "./took-item.pid"`

rm -f "./took-item.pid" >/dev/null 2>&1

echo "stoped"
